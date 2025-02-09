package com.vikingz.campustycoon.Game.GameLogic;

import com.vikingz.campustycoon.Game.Buildings.*;
import com.vikingz.campustycoon.UI.Components.MenuText;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to keep track of the number of buildings in the game.
 */
public class BuildingCounter {
    private static int totalBuildingCount = 0;

	// [0] = "Accommodation", [1] = "Study", [2] = "Cafeteria", [3] = "Relaxation", [4] = "null"
	private static int[] buildingCounts = new int[5];
	public static List<MenuText> UI = new ArrayList<MenuText>();
	public static MenuText totalCountUI;

	/**
	 * Resets the counter
	 */
	public static void reset() {
		totalBuildingCount = 0;
		buildingCounts = new int[5];
		UI = new ArrayList<MenuText>();
	}

	/**
	 * Gets the total building count.
	 * @return The total building count.
	 */
    public static int getTotalBuildingCount() {
        return totalBuildingCount;
    }

	/**
	 * Gets the building count of a specific building.
	 * @param building The building to get the count of.
	 * @return The building count.
	 */
	public static int getBuildingCount(String building) {
		return buildingCounts[getBuildingCountIndex(building)];
	}


	/**
	 * Updates the display;
	 */
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

	/**
	 * CHANGED
	 *
	 * Gets the building count by the building id.
	 * @param building The building id.
	 * @return The building count.
	 */
	public static int getBuildingCountByBuilding(String building){
		switch (building) {
			case "Accommodation":
				return buildingCounts[0];

			case "Study":
				return buildingCounts[1];

			case "Cafeteria":
				return buildingCounts[2];

			case "Relaxation":
				return buildingCounts[3];

			case "default":
				return buildingCounts[4];

			default:
				return -1;
		}

	}


	/**
	 * Increases the building count of a specific building.
	 * @param building The building to increase the count of.
	 * @param value The value to increase the count by.
	 */
	public static void increaseBuildingCounter(String building, int value) {
		buildingCounts[getBuildingCountIndex(building)] += value;
        increaseBuildingCounter(value);
    }

	/**
	 * Decreases the building count.
	 * @param building The building to decrease the count of.
	 * @param value The value to decrease the count by.
	 */
    public static void decreaseBuildingCounter(String building, int value) {
		buildingCounts[getBuildingCountIndex(building)] -= value;
        decreaseBuildingCounter(value);
    }


	/**
	 * Increases the total building count.
	 * @param value The value to increase the total building count by.
	 */
    public static void increaseBuildingCounter(int value) {
        totalBuildingCount += value;
		updateDisplay();
    }

	/**
	 * Decreases the total building count.
	 * @param value The value to decrease the total building count by.
	 */
    public static void decreaseBuildingCounter(int value) {
        totalBuildingCount -= value;
		updateDisplay();
    }

}
