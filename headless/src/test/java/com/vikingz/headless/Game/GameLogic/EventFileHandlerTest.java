package com.vikingz.headless.Game.GameLogic;

import com.vikingz.Game.GameLogic.EventLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventFileHandlerTest {

    //Test files
    String validFile = "testFiles/eventTest.yml";
    String invalidFile = "testFiles/eventTestInvalid.yml";

    /**
     * Tests if events can be loaded from valid and if the correct Exception is flagged if invalid
     * @throws IOException If there's an issue with the test file that not expected
     */
    @Test
    public void test_load_events() throws IOException {

        //testEvents
        ArrayList<String> eventList = new ArrayList<>();
        HashMap<String,String> descriptionLookup = new HashMap<>();
        HashMap<String, Integer> acceptGainLookup = new HashMap<>();
        HashMap<String, Integer> acceptCostLookup = new HashMap<>();
        HashMap<String, Integer> neutralGainLookup = new HashMap<>();
        HashMap<String, Integer> neutralCostLookup = new HashMap<>();
        HashMap<String, Integer> rejectGainLookup = new HashMap<>();
        HashMap<String, Integer> rejectCostLookup = new HashMap<>();

        //events
        eventList.add("event1");
        eventList.add("event2");
        //descriptions
        descriptionLookup.put("event1","description");
        descriptionLookup.put("event2","description2");
        //accept
        acceptGainLookup.put("event1",300);
        acceptGainLookup.put("event2",100);
        acceptCostLookup.put("event1",1000);
        acceptCostLookup.put("event2",500);
        //neutral
        neutralGainLookup.put("event1",-100);
        neutralGainLookup.put("event2",100);
        neutralCostLookup.put("event1",0);
        neutralCostLookup.put("event2",0);
        //reject
        rejectGainLookup.put("event1",-100);
        rejectGainLookup.put("event2",-300);
        rejectCostLookup.put("event1",-2000);
        rejectCostLookup.put("event2",0);


        //Output Current task
        System.out.println("> Testing test_load_events()");

        //Valid EventLoader Tests
        new EventLoader(validFile, true);
        assertEquals(eventList,EventLoader.getEventList());
        assertEquals(acceptGainLookup,EventLoader.getAcceptGainLookup());
        assertEquals(acceptCostLookup, EventLoader.getAcceptCostLookup());
        assertEquals(neutralGainLookup,EventLoader.getNeutralGainLookup());
        assertEquals(neutralCostLookup,EventLoader.getNeutralCostLookup());
        assertEquals(rejectGainLookup,EventLoader.getRejectGainLookup());
        assertEquals(rejectCostLookup,EventLoader.getRejectCostLookup());
        EventLoader.resetStatics();

        try {
            new EventLoader(invalidFile, true);
        } catch (Exception e){
            assertEquals(new IOException("File Is invalid").getLocalizedMessage(),e.getLocalizedMessage());
        }
        EventLoader.resetStatics();
        System.out.println("> Finished test_load_events()");
    }


    /**
     * Checks that the method lookup switch case working
     */
    @Test
    public void test_method_actions(){
        HashMap<String, Integer> acceptGainLookup = new HashMap<>();
        HashMap<String, Integer> acceptCostLookup = new HashMap<>();
        HashMap<String, Integer> neutralGainLookup = new HashMap<>();
        HashMap<String, Integer> neutralCostLookup = new HashMap<>();
        HashMap<String, Integer> rejectGainLookup = new HashMap<>();
        HashMap<String, Integer> rejectCostLookup = new HashMap<>();

        //accept
        acceptGainLookup.put("event1",300);
        acceptGainLookup.put("event2",100);
        acceptCostLookup.put("event1",1000);
        acceptCostLookup.put("event2",500);
        //neutral
        neutralGainLookup.put("event1",-100);
        neutralGainLookup.put("event2",100);
        neutralCostLookup.put("event1",0);
        neutralCostLookup.put("event2",0);
        //reject
        rejectGainLookup.put("event1",-100);
        rejectGainLookup.put("event2",-300);
        rejectCostLookup.put("event1",-2000);
        rejectCostLookup.put("event2",0);


        System.out.println("> Testing test_method_actions()");
        try {
            new EventLoader(validFile, true);
        } catch (Exception e){
            assertEquals(new IOException("File Is invalid").getLocalizedMessage(),e.getLocalizedMessage());
        }

        //Gain
        assertEquals(acceptGainLookup.get("event1"),EventLoader.getActionGain("accept","event1"));
        assertEquals(neutralGainLookup.get("event1"),EventLoader.getActionGain("neutral","event1"));
        assertEquals(rejectGainLookup.get("event1"),EventLoader.getActionGain("reject","event1"));
        assertEquals(acceptGainLookup.get("event2"),EventLoader.getActionGain("accept","event2"));
        assertEquals(neutralGainLookup.get("event2"),EventLoader.getActionGain("neutral","event2"));
        assertEquals(rejectGainLookup.get("event2"),EventLoader.getActionGain("reject","event2"));

        //costs
        assertEquals(acceptCostLookup.get("event1"),EventLoader.getActionCost("accept","event1"));
        assertEquals(neutralCostLookup.get("event1"),EventLoader.getActionCost("neutral","event1"));
        assertEquals(rejectCostLookup.get("event1"),EventLoader.getActionCost("reject","event1"));
        assertEquals(acceptCostLookup.get("event2"),EventLoader.getActionCost("accept","event2"));
        assertEquals(neutralCostLookup.get("event2"),EventLoader.getActionCost("neutral","event2"));
        assertEquals(rejectCostLookup.get("event2"),EventLoader.getActionCost("reject","event2"));

        //no event
        assertEquals(EventLoader.getActionCost("null","null"),-1);

        EventLoader.resetStatics();
        System.out.println("> Finished test_method_actions()");
    }


}
