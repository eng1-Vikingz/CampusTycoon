package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
 * The Accommodation class represents a building of type Accommodation in the game.
 * It extends the Building class and provides specific properties and behaviors for Accommodation buildings.
 * This class includes methods to increment the building counter and constructors to initialize the building.
 */
public class Accommodation extends Building {

	public static final String defaultImage = "Buildings\\acom1.png";
	public static final String buildingName = "Accommodation";
	public static int cost = 200;
	public static int width = 3;
	public static int height = 3;

	/**
	 * Constructs an Accommodation building with the specified position.
	 *
	 * @param Position The coordinate position of the building.
	 */
	public Accommodation(Coordinate Position) {
		super(Position, defaultImage, cost, width, height);
		score = 200;
	}

	/**
	 * Constructs an Accommodation building with the default position (0, 0).
	 */
	public Accommodation() {
		super(new Coordinate(0, 0), defaultImage, cost, width, height);
		score = 200;
	}

	/**
	 * Increments the building counter for Accommodation buildings by 1.
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
