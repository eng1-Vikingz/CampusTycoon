package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
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
	public static final String[] defaultImage = {"Buildings\\Study.png", "Buildings\\Study2.png"};
	public static final String buildingName = "Study";
	public static final String buildingName2 = "Study2";
    public static int cost = 100;
	public static int width = 3, height = 3;


	public Study(Coordinate Position, int textureIndex) {
		super(Position, defaultImage[textureIndex],cost, width , height);
        score = 300;
	}
	public Study(int textureIndex) {
		super(new Coordinate(0, 0), defaultImage[textureIndex], cost, width , height);
        score = 300;
	}


	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
