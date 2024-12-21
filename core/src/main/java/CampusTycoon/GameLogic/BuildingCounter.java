package CampusTycoon.GameLogic;

import CampusTycoon.Buildings.*;
import CampusTycoon.UI.Components.MenuText;

import java.util.ArrayList;
import java.util.List;

public class BuildingCounter {
    private static int totalBuildingCount = 0;
	
	// [0] = "Accommodation", [1] = "Study", [2] = "Cafeteria", [3] = "Relaxation", [4] = "null"
	private static int[] buildingCounts = new int[5];
	public static List<MenuText> UI = new ArrayList<MenuText>();
	public static MenuText totalCountUI;
	
	public static void reset() {
		totalBuildingCount = 0;
		buildingCounts = new int[5];
		UI = new ArrayList<MenuText>();
	}

    public static int getTotalBuildingCount() {
        return totalBuildingCount;
    }
	
	public static int getBuildingCount(String building) {
		return buildingCounts[getBuildingCountIndex(building)];
	}
	
	public static void updateDisplay() {
		if (UI.isEmpty()) {
			return;
		}
		
		for (int i = 0; i < buildingCounts.length - 1; i++) {
			MenuText textDisplay = UI.get(i);
			textDisplay.text = String.valueOf(buildingCounts[i]);
			textDisplay.update();
		}
		totalCountUI.text = String.valueOf(totalBuildingCount);
		totalCountUI.update();
	}
	
	private static int getBuildingCountIndex(String building) {
		switch (building) {
			case Accommodation.buildingName:
				return 0;
			case Study.buildingName:
				return 1;
			case Cafeteria.buildingName:
				return 2;
			case Relaxation.buildingName:
				return 3;
			default:
				return 4; // Default building
		}
	}
	
	
	public static void increaseBuildingCounter(String building, int value) {
		buildingCounts[getBuildingCountIndex(building)] += value;
        increaseBuildingCounter(value);
    }

    public static void decreaseBuildingCounter(String building, int value) {
		buildingCounts[getBuildingCountIndex(building)] -= value;
        decreaseBuildingCounter(value);
    }
	

    public static void increaseBuildingCounter(int value) {
        totalBuildingCount += value;
		updateDisplay();
    }

    public static void decreaseBuildingCounter(int value) {
        totalBuildingCount -= value;
		updateDisplay();
    }

}
