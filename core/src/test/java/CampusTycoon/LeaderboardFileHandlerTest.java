package CampusTycoon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import CampusTycoon.UI.LeaderboardFileHandler;
import CampusTycoon.UI.Tuple;

public class LeaderboardFileHandlerTest {
    
    @Test
    public void test_getLeaderboard(){

        String filename = "JUNIT_TEST1.txt";
        // The file we are using for our tests has to be removed as the function addLeaderboardEntry
        // appends data to the existing file, ie whenever this test is ran the data will be written to the file again.
        LeaderboardFileHandler.removeFile(filename);
        
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test1", 100);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test1", 200);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test2", 500);
        

        HashMap<String, List<Integer>> leaderboard = LeaderboardFileHandler.getLeaderboard(filename);
        HashMap<String, List<Integer>> expectedLeaderboard = new HashMap<>();
        
        List<Integer> test1List = new ArrayList<>();
        test1List.add(100);
        test1List.add(200);
        expectedLeaderboard.put("test1", test1List);        
        
        List<Integer> test2List = new ArrayList<>();
        test2List.add(500);
        expectedLeaderboard.put("test2", test2List);        

        assertEquals(expectedLeaderboard, leaderboard);
        LeaderboardFileHandler.removeFile(filename);

    }

    @Test
    public void test_addLeaderboardEntry(){
        String filename = "JUNIT_TEST2.txt";
        LeaderboardFileHandler.removeFile(filename);
        
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test1", 100);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test1", 200);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test2", 500);

        HashMap<String, List<Integer>> leaderboard = LeaderboardFileHandler.getLeaderboard(filename);
        HashMap<String, List<Integer>> expectedLeaderboard = new HashMap<>();
        
        List<Integer> test1List = new ArrayList<>();
        test1List.add(100);
        test1List.add(200);
        expectedLeaderboard.put("test1", test1List);        
        
        List<Integer> test2List = new ArrayList<>();
        test2List.add(500);
        expectedLeaderboard.put("test2", test2List);        

        assertEquals(expectedLeaderboard, leaderboard);

        // Add a new item
        LeaderboardFileHandler.addLeaderboardEntry(filename,"test2", 700);
        leaderboard = LeaderboardFileHandler.getLeaderboard(filename);

        test2List.add(700);
        expectedLeaderboard.put("test2", test2List);  

        assertEquals(expectedLeaderboard, leaderboard);

        LeaderboardFileHandler.removeFile(filename);
    }

    @Test
    public void test_getLeaderboardTopFive(){

        String filename = "JUNIT_TEST3.txt";
        // The file we are using for our tests has to be removed as the function addLeaderboardEntry
        // appends data to the existing file, ie whenever this test is ran the data will be written to the file again.
        LeaderboardFileHandler.removeFile(filename);
        
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test1", 1000);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test1", 900);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test2", 800);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test3", 700);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test3", 600);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test4", 500);
        LeaderboardFileHandler.addLeaderboardEntry(filename, "test4", 400);

        ArrayList<Tuple<String, Integer>> topFiveLeaderboard = LeaderboardFileHandler.getLeaderboardTopFive(filename);

        ArrayList<Tuple<String, Integer>> expectedtopFiveLeaderboard = new  ArrayList<Tuple<String, Integer>>();

        expectedtopFiveLeaderboard.add(new Tuple<String,Integer>("test1", 1000));
        expectedtopFiveLeaderboard.add(new Tuple<String,Integer>("test1", 900));
        expectedtopFiveLeaderboard.add(new Tuple<String,Integer>("test2", 800));
        expectedtopFiveLeaderboard.add(new Tuple<String,Integer>("test3", 700));
        expectedtopFiveLeaderboard.add(new Tuple<String,Integer>("test3", 600));


        assertEquals(expectedtopFiveLeaderboard, topFiveLeaderboard);
        LeaderboardFileHandler.removeFile(filename);

    }


    @Test
    public void test_createFile(){
        String filename = "JUNIT_TEST2.txt";
        LeaderboardFileHandler.removeFile(filename);

        LeaderboardFileHandler.createNewFile(filename);
        File file = new File(filename);
        assertTrue(file.exists() && !file.isDirectory());

        LeaderboardFileHandler.removeFile(filename);


    }

    @Test
    public void test_removeFile(){
        String filename = "JUNIT_TEST2.txt";
        LeaderboardFileHandler.removeFile(filename);
        LeaderboardFileHandler.createNewFile(filename);

        LeaderboardFileHandler.removeFile(filename);

        File file = new File(filename);
        assertTrue(!(file.exists() && !file.isDirectory()));

        LeaderboardFileHandler.removeFile(filename);


    }

}
