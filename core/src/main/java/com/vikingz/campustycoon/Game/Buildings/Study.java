package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
 * This class is used to create a Study building.
 *
 * CHANGED
 *
 * This class was originally made so that it
 * had the path to the texture hard coded, so i changed it
 * into an array where the user can change the texture based on
 * the index of the array.
 */
public class Study extends Building{
	/**
	 * Changed default image to be an array, therefore we can have multiple textures
	 */
	public static final String[] defaultImage = {"Buildings\\rch.png", "Buildings\\pza.png"};
	public static final String buildingName = "Study";
	public static final String buildingName2 = "Study2";
    public static int cost = 100;
	public static int width = 3, height = 3;


	/**
	 * Constructor for Study building.
	 * @param Position The position of the building.
	 * @param textureIndex The texture index of the building.
	 */
	public Study(Coordinate Position, int textureIndex) {
		super(Position, defaultImage[textureIndex],cost, width , height);
        score = 300;
	}

	/**
	 * Constructor for Study building.
	 * @param textureIndex The texture index of the building.
	 */
	public Study(int textureIndex) {
		super(new Coordinate(0, 0), defaultImage[textureIndex], cost, width , height);
        score = 300;
	}

	/**
	 * Constructor for Study building.
	 */
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}

    /**
     * Decrement the building counter for the building by 1.
     */
    @Override
    public void decrementBuildingCounter() {
        BuildingCounter.decreaseBuildingCounter(buildingName, 1);
    }
}
