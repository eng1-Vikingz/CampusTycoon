package CampusTycoon.GameLogic;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.yaml.snakeyaml.Yaml;

import java.io.*;


import java.util.*;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


/**
 * Class that handles loading events from yaml file
 * featuring dictionaries for events are Strings for example event1
 * with description that will show to the user as a popup
 * with results of button being clicked:
 * cost being money cost
 * gain being satisfaction gain or lost due to event
 */
public class EventLoader {
    public static ArrayList<String> eventList = new ArrayList<>();
    public static HashMap<String,String> descriptionLookup = new HashMap<>();
    public static HashMap<String, Integer> acceptGainLookup = new HashMap<>();
    public static HashMap<String, Integer> acceptCostLookup = new HashMap<>();
    public static HashMap<String, Integer> neutralGainLookup = new HashMap<>();
    public static HashMap<String, Integer> neutralCostLookup = new HashMap<>();
    public static HashMap<String, Integer> rejectGainLookup = new HashMap<>();
    public static HashMap<String, Integer> rejectCostLookup = new HashMap<>();
    private static Random rand;

    public EventLoader() {
        final Properties modules = new Properties();
        try {
            FileHandle fileReader = Gdx.files.internal("event.yml");
            String yamlFile = fileReader.readString();
            Yaml yaml = new Yaml();
            Map<String, Object> data = (Map<String, Object>) yaml.load(yamlFile);
            eventList.addAll((Collection<? extends String>) data.get("eventList"));
            System.out.println(eventList);
            for (String event : eventList) {
                final List<Map<String, Object>> values = (List<Map<String, Object>>) data.get(event);
                modules.putAll(values.stream().filter(Objects::nonNull)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

                descriptionLookup.put(event, (String) modules.get("Description"));

                //accept
                acceptGainLookup.put(event, (Integer) modules.get("acceptGain"));
                acceptCostLookup.put(event, (Integer) modules.get("acceptCost"));

                //neutral
                neutralGainLookup.put(event, (Integer) modules.get("neutralGain"));
                neutralCostLookup.put(event, (Integer) modules.get("neutralCost"));

                //reject
                rejectGainLookup.put(event, (Integer) modules.get("rejectGain"));
                rejectCostLookup.put(event, (Integer) modules.get("rejectCost"));
            }
        } catch (Exception e){
            System.err.println("there was a issue trying to read events yaml file");
        }
        rand = ThreadLocalRandom.current();
        System.out.println("Events loaded");

    }

    /**
     *  randomly returns a event String
     *  @return String event
     */
    public static String getEvent(){
        if (eventList.size() == 1){
            return eventList.get(0);
        }
        return eventList.get(rand.nextInt(0,eventList.size()));
    }

    /**
     * Returns the description of the event to be shown to the user
     * @param event string
     * @return description String
     */
    public static String getEventDescription(String event){
        return descriptionLookup.get(event);
    }

    /**
     * gets cost os choosing the selected action
     * @param action string
     * @param event string
     * @return cost int
     */
    public static int getActionCost(String action,String event){
        return switch (action) {
            case "accept" -> acceptCostLookup.get(event);
            case "neutral" -> neutralCostLookup.get(event);
            case "reject" -> rejectCostLookup.get(event);
            default -> -1;
        };
    }



    /**
     * Gets satisfaction gain/lost due to a event
     * @param action string
     * @param event string
     * @return satisfaction int
     */
    public static int getActionGain(String action,String event){
        return switch (action) {
            case "accept" -> acceptGainLookup.get(event);
            case "neutral" -> neutralGainLookup.get(event);
            case "reject" -> rejectGainLookup.get(event);
            default -> -1;
        };
    }




    /**
     * getters for hashMaps Dictionaries
     * @return string / integer
     */
    public static ArrayList<String> getEventList() {
        return eventList;
    }

    public static HashMap<String, String> getDescriptionLookup() {
        return descriptionLookup;
    }

    public static HashMap<String, Integer> getAcceptGainLookup() {
        return acceptGainLookup;
    }

    public static HashMap<String, Integer> getAcceptCostLookup() {
        return acceptCostLookup;
    }

    public static HashMap<String, Integer> getNeutralGainLookup() {
        return neutralGainLookup;
    }

    public static HashMap<String, Integer> getNeutralCostLookup() {
        return neutralCostLookup;
    }

    public static HashMap<String, Integer> getRejectGainLookup() {
        return rejectGainLookup;
    }

    public static HashMap<String, Integer> getRejectCostLookup() {
        return rejectCostLookup;
    }
}
