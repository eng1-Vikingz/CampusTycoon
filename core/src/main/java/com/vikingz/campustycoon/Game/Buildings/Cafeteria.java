package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
 * The Cafeteria class represents a building of type Cafeteria in the game.
 */
public class Cafeteria extends Building {
	public static final String defaultImage = "Buildings\\macd.png";
	public static final String buildingName = "Cafeteria";
    public static int cost = 100;
	public static int width = 3, height = 3;

	/**
	 * Constructs a Cafeteria building with the default position (0, 0).
	 * @param Position The coordinate position of the building.
	 */ 
	public Cafeteria(Coordinate Position) {
		super(Position, defaultImage, cost,width , height);
        score = 300;
	}

	/**
	 * Constructs a Cafeteria building with the default position (0, 0).
	 */
	public Cafeteria() {
		super(new Coordinate(0, 0), defaultImage, cost, width , height);
        score = 300;
	}

	
	/**
	 * Increments the building counter for Cafeteria buildings by 1.
	 */
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
