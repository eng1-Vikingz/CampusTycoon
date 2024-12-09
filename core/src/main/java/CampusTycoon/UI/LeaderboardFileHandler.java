package CampusTycoon.UI;

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

public class LeaderboardFileHandler{

    static String FILE_NAME = "test.txt";


    public static HashMap<String, List<Integer>> getLeaderboard(){

        HashMap<String, List<Integer>> leaderboard = new HashMap<String, List<Integer>>();

        try(Scanner reader = new Scanner(new File(FILE_NAME))){
            while(reader.hasNextLine()){

                String[] line = reader.nextLine().split(",");

                ArrayList<Integer> values = stringListToIntList(Arrays.asList(line).subList(1, line.length));

                leaderboard.put(line[0], values);

            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("'" + FILE_NAME + "' did not exist!");
            createNewFile();
            
        }
        return leaderboard;
    } 

    private static ArrayList<Integer> stringListToIntList(List<String> list){
        ArrayList<Integer> intList = new ArrayList<>();

        for(String x : list){
            intList.add(Integer.parseInt(x));
        }
        return intList;
    }


    public static boolean addLeaderboardEntry(String key, Integer value){

        HashMap<String, List<Integer>> leaderboard = getLeaderboard();
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
            FileWriter myWriter = new FileWriter(FILE_NAME);


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


    public static ArrayList<Tuple<String, Integer>> getLeaderboardTopFive(){

        HashMap<String, List<Integer>> leaderboard = getLeaderboard();
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

    private static boolean createNewFile(){
        try{
            File newFile = new File(FILE_NAME);
            if(newFile.createNewFile()){
                System.out.println("Created new file: '" + FILE_NAME + "'");
                return true;
            }

        }
        catch(IOException e){
            System.out.println("An error occured, could not create file");
        }
        return false;
    }

}
