package CampusTycoon.Util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.stream.Collectors;

import CampusTycoon.Util.Types.Tuple;

public class LeaderboardFileHandler{

    public static String FILE_NAME = "test.txt";


    public static HashMap<String, List<Integer>> getLeaderboard(String filename){

        HashMap<String, List<Integer>> leaderboard = new HashMap<String, List<Integer>>();

        try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNextLine()){

                String[] line = reader.nextLine().split(",");

                ArrayList<Integer> values = stringListToIntList(Arrays.asList(line).subList(1, line.length));

                leaderboard.put(line[0], values);

            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("'" + filename + "' did not exist!");
            createNewFile(filename);
            
        }
        return leaderboard;
    } 

    public static HashMap<String, List<Integer>> getLeaderboard(){
        return getLeaderboard(FILE_NAME);
    }

    private static ArrayList<Integer> stringListToIntList(List<String> list){
        ArrayList<Integer> intList = new ArrayList<>();

        for(String x : list){
            intList.add(Integer.parseInt(x));
        }
        return intList;
    }


    public static boolean addLeaderboardEntry(String filename, String key, Integer value){

        HashMap<String, List<Integer>> leaderboard = getLeaderboard(filename);
        if(leaderboard.keySet().contains(key)){
            List<Integer> values = leaderboard.get(key);
            values.add(value);
            leaderboard.put(key, values);
        }
        else{
            List<Integer> newValue = new ArrayList<>();
            newValue.add(value);

            leaderboard.put(key, newValue);
        }


        try {
            FileWriter myWriter = new FileWriter(filename);


            for(String x : leaderboard.keySet()){

                List<Integer> values = leaderboard.get(x);
                List<String> strList = values.stream().map(String::valueOf).collect(Collectors.toList());
                String valuesStr = String.join(",", strList);
                myWriter.write(x + "," + valuesStr + "\n");

            }


            myWriter.close();

        }
        catch(IOException e){
            System.out.println("Could not add new entry '" + key + "': '" + value + "' to file!");
        }
        return false;
    }

    public static boolean addLeaderboardEntry(String key, Integer value){
        return addLeaderboardEntry(FILE_NAME, key, value);
    }


    public static ArrayList<Tuple<String, Integer>> getLeaderboardTopFive(String filename){

        HashMap<String, List<Integer>> leaderboard = getLeaderboard(filename);
        ArrayList<Tuple<String, Integer>> best = new ArrayList<>();

        ArrayList<String> keys = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();


        for(String key : leaderboard.keySet()){

            List<Integer> keyValues = leaderboard.get(key);

            for(Integer x : keyValues){
                keys.add(key);
                values.add(x);
            }

        }

        for(int i = 0; i < 5; i++){

            try{
                int index = getMax(values);
                best.add(new Tuple<String,Integer>(keys.get(index), values.get(index)));
    
                System.out.println(keys.get(index) + "::" + values.get(index));
    
                keys.remove(index);
                values.remove(index);

            }
            catch(Exception e){
                break;
            }
        }

        return best;
        
    }

    public static ArrayList<Tuple<String, Integer>> getLeaderboardTopFive(){
        return getLeaderboardTopFive(FILE_NAME);
    }

    private static int getMax(ArrayList<Integer> values){

        int index = -1;
        int maxVal = -1;
        for (int i = 0; i < values.size(); i++){
            if(values.get(i) > maxVal){
                maxVal = values.get(i);
                index = i;
            }
        }
        return index;
    }

    public static boolean createNewFile(String filename){
        try{
            File newFile = new File(filename);
            if(newFile.createNewFile()){
                System.out.println("Created new file: '" + filename + "'");
                return true;
            }

        }
        catch(IOException e){
            System.out.println("An error occured, could not create file");
        }
        return false;
    }

    public static boolean createNewFile(){
        return createNewFile(FILE_NAME);
    }

    public static boolean removeFile(String filename){
        File file = new File(filename);
        Boolean result = file.delete();

        if(result){
            System.out.println("Removed: " + filename);
        }
        else{
            System.out.println("Could not remove " + filename);
        }
        return result;
        
    }

}
