package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
 * This class is used to create a Relaxation building.
 */
public class Relaxation extends Building {
	public static final String[] defaultImage = {"Buildings\\ysv.png", "Buildings\\pub.png"};
	public static final String buildingName = "Relaxation";
	public static final String buildingName2 = "Relaxation2";
    public static int cost = 200;
	public static int width = 3, height = 3;


	/**
	 * Constructor for Relaxation building.
	 * @param Position The position of the building.
	 * @param textureIndex The texture index of the building.
	 */
	public Relaxation(Coordinate Position, int textureIndex) {
		super(Position, defaultImage[textureIndex],cost, width , height);
        score = 200;
	}

	/**
	 * Constructor for Relaxation building.
	 * @param textureIndex The texture index of the building.
	 */
	public Relaxation(int textureIndex) {
		super(new Coordinate(0, 0), defaultImage[textureIndex],cost, width , height);
        score = 200;
	}


	/**
	 * Constructor for Relaxation building.
	 * @param Position The position of the building.
	 */
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
