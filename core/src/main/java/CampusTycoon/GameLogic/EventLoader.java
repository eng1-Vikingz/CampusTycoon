package CampusTycoon.GameLogic;



import org.yaml.snakeyaml.Yaml;

import java.io.*;


import java.util.*;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


/*
class loads all events from yml file
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
            Reader yamlFile = new FileReader("event.yml");
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
        System.out.println(getEvent());
    }

    //randomly returns a event
    public static String getEvent(){
        if (eventList.size() == 1){
            return eventList.get(0);
        }
        return eventList.get(rand.nextInt(0,eventList.size()));
    }

    public static String getEventDescription(String event){
        return descriptionLookup.get(event);
    }

    //gets cost of choosing an action
    public static int getActionCost(String action,String event){
        return switch (action) {
            case "accept" -> acceptCostLookup.get(event);
            case "neutral" -> neutralCostLookup.get(event);
            case "reject" -> rejectCostLookup.get(event);
            default -> -1;
        };
    }

    //Get gains of choosing an action
    public static int getActionGain(String action,String event){
        return switch (action) {
            case "accept" -> acceptGainLookup.get(event);
            case "neutral" -> neutralGainLookup.get(event);
            case "reject" -> rejectGainLookup.get(event);
            default -> -1;
        };
    }


    //getters for hashMaps Dictionaries
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
