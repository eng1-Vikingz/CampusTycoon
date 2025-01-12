package com.vikingz.campustycoon.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Game.GameLogic.MoneyHandler;
import com.vikingz.campustycoon.Game.GameLogic.SatisfactionMeter;
import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.Util.Types.Achievement;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is used to create and manage achievements.
 */
public class Achievements {

    public ArrayList<String> achievementNameList = new ArrayList<>();
    private final HashMap<String,AchievementTargetTypes> achievementTypeList = new HashMap<>();
    private final HashMap<String, Integer> achievementTargetValueList = new HashMap<>();
    public final ArrayList<Achievement> achievementList = new ArrayList<>();

    /**
     * HashSet to store all achieved achievements
     */
    public final HashSet<String> achievedSet = new HashSet<>();


    /**
     * Enum for the different types of achievements
     */
    public enum AchievementTargetTypes {
        NumberOfBuildings,
        NumberOfAccommindationBuildings,
        NumberOfCafeteriaBuildings,
        NumberOfRelaxationBuildings,
        NumberOfStudyBuildings,
        SatisfactionScore,
        AmountOfMoney,

        Bankrupt
    }


    /**
     * loads data via SnakeYaml Parser and loads all needed data into HashMaps
     * @param yamlFile path to file
     * @throws IOException if no file is found
     */
    @SuppressWarnings("unchecked")
    public boolean loadYamlContents(String yamlFile) throws IOException {
        try {
            final Properties modules = new Properties();
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(yamlFile);
            achievementNameList.addAll((Collection<? extends String>) data.get("achievementList"));
            System.out.println(achievementNameList);
            for (String achievement : achievementNameList) {
                final List<Map<String, Object>> values = (List<Map<String, Object>>) data.get(achievement);
                modules.putAll(values.stream().filter(Objects::nonNull)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
                achievementTypeList.put(achievement,AchievementTargetTypes.valueOf((String) modules.get("type")));
                achievementTargetValueList.put(achievement,(Integer) modules.get("target"));
                achievementList.add(new Achievement(achievement,achievementTypeList.get(achievement),achievementTargetValueList.get(achievement)));
            }

        }
        catch (Exception e){
            throw new IOException("File Is invalid");
        }
        System.out.println("Achievements loaded");
        return true;
    }

    /**
     * Creates a new file to store the achieved achievements
     * @return
     */
    public boolean createNewCheckFile(){
        try{

            FileHandle File = Gdx.files.local("achieved.csv");
            if(File.file().createNewFile()){
                System.out.println("Created new file: 'achieved.csv'");
                return true;
            }

        }
        catch(IOException e){
            System.out.println("An error occurred, could not create file");
        }
        return false;
    }

    /**
     * Checks if the file exists
     * @return
     */
    public boolean checkForCheckFile(){
        FileHandle File = Gdx.files.local("achieved.csv");
        if(File.exists()){
            return true;
        }
        return createNewCheckFile();
    }


    /**
     * Updates the file with the new achieved achievements
     * @return
     */
    public boolean updateCheckFile(){
        if (!checkForCheckFile()){
            return false;
        }
        FileHandle File = Gdx.files.local("achieved.csv");
        String oldSet = File.readString();
        for (String old : oldSet.split(",")) {
            achievedSet.add(old);
        }
        File.writeString(achievedSetToCsv(),false);
        return true;
    }


    public Achievements(String file){
        try {
            FileHandle fileReader = Gdx.files.internal(file);
            String yamlFile = fileReader.readString();
            if(!loadYamlContents(yamlFile)){
                throw new IOException("There has been a problem loading yaml into dictionaries");
            }

        } catch (Exception e){
            System.err.println("there was a issue trying to read events yaml file,\n" + e);
        }

    }



    /**
     * Because you can't use libgdx file handler without lwjgl applicationLister,
     * using java native file handling instead.
     * @param file String of path of File
     * @param test Boolean of if test being used
     */
    public Achievements(String file,boolean test) throws IOException {
        if (test){
            String yamlFile = new Scanner(new File(file)).useDelimiter("\\Z").next();
            if(!loadYamlContents(yamlFile)){
                throw new IOException("There has been a problem loading yaml into dictionaries");
            }
        }
        else{
            throw new IOException("absolutePath Isn't supported while not in test mode");
        }
    }

    public ArrayList<Achievement> getAchievementList() {
        return achievementList;
    }
    public ArrayList<String> getAchievementNameList() {
        return achievementNameList;
    }

    public HashMap<String, AchievementTargetTypes> getAchievementTypeList() {
        return achievementTypeList;
    }

    public HashMap<String, Integer> getAchievementTargetValueList() {
        return achievementTargetValueList;
    }

    public int getTarget(AchievementTargetTypes target){
        switch (target){
            case NumberOfBuildings:
                return BuildingCounter.getTotalBuildingCount();
            case NumberOfAccommindationBuildings:
                return BuildingCounter.getBuildingCount("Accommodation");
            case NumberOfCafeteriaBuildings:
                return BuildingCounter.getBuildingCount("Cafeteria");
            case NumberOfRelaxationBuildings:
                return BuildingCounter.getBuildingCount("Relaxation");
            case NumberOfStudyBuildings:
                return BuildingCounter.getBuildingCount("Study");
            case SatisfactionScore:
                return SatisfactionMeter.getSatisfactionScore();
            case AmountOfMoney:
                return MoneyHandler.getMoney();
            case Bankrupt:
                if(MoneyHandler.isPreviousBankrupt()){
                    return -999;
                }
            default:
                return -1;
        }
    }

    public String achievedSetToCsv(){
        String str = "";
        for (String achieved : achievedSet){
            if (!(achieved == "")) {
                str += achieved + ",";
            }
        }
        return str;
    }

    public void checkForAchieved(){
        for (Achievement achievement: achievementList){
            if (achievement.isAchieved()){
                achievedSet.add(achievement.name);
            }
        }
        updateCheckFile();
    }


    public void checkForTargets(GameplayScreen gameplayScreen){
        boolean unlocked = false;
        checkForAchieved();
        for (Achievement achievement: achievementList){
            if (getTarget(achievement.type) >= achievement.target && !(achievement.target == 0) && !achievement.isAchieved() && !(achievedSet.contains(achievement.name)) ) {
                achievement.hasBeenAchieved();
                ((GameplayScreen) ScreenUtils.gameplayScreen).displayAchievementPopUp(achievement);
                unlocked = true;
            }
            else if (achievement.type == AchievementTargetTypes.Bankrupt && getTarget(achievement.type) == -999 && !achievement.isAchieved() &&  !(achievedSet.contains(achievement.name))){
                achievement.hasBeenAchieved();
                ((GameplayScreen) ScreenUtils.gameplayScreen).displayAchievementPopUp(achievement);
                unlocked = true;
            }
        }
        if (unlocked){
            checkForAchieved();
        }
    }

}
