package com.vikingz.campustycoon.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Achievements {

    public static ArrayList<String> achievementList = new ArrayList<>();
    private static final HashMap<String,AchievementTargetTypes> achievementTypeList = new HashMap<>();
    private static final HashMap<String, Integer> achievementTargetValueList = new HashMap<>();


    enum AchievementTargetTypes {
        NumberOfBuildings,
        NumberOfAccommindationBuildings,
        NumberOfCafeteriaBuildings,
        NumberOfRelaxationBuildings,
        NumberOfStudyBuildings,
        SatisfactionScore,
        AmountOfMoney
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
            achievementList.addAll((Collection<? extends String>) data.get("achievementList"));
            System.out.println(achievementList);
            for (String achievement : achievementList) {
                final List<Map<String, Object>> values = (List<Map<String, Object>>) data.get(achievement);
                modules.putAll(values.stream().filter(Objects::nonNull)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

                achievementTypeList.put(achievement,AchievementTargetTypes.valueOf((String) modules.get("type")));
                achievementTargetValueList.put(achievement,(Integer) modules.get("target"));
            }
        }
        catch (Exception e){
            throw new IOException("File Is invalid");
        }
        System.out.println("Achievements loaded");
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

    public static ArrayList<String> getAchievementList() {
        return achievementList;
    }

    public static HashMap<String, AchievementTargetTypes> getAchievementTypeList() {
        return achievementTypeList;
    }

    public static HashMap<String, Integer> getAchievementTargetValueList() {
        return achievementTargetValueList;
    }
}
