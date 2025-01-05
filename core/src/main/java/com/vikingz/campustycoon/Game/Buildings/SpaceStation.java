package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Util.Types.Coordinate;

// This "building" is used when you attempt to place something outside the map
// Should probably just not allow that to happen, but I think this is funnier

// EDIT: This has since been removed from the game, but has been kept for 
// testing purposes.

/**
 * This class is used to create a SpaceStation building.
 */
public class SpaceStation extends Building {
	public static final String defaultImage = "Buildings\\SpaceStation.png";
	public static final String buildingName = "SpaceStation";
    public static int cost = 0;
	public static int width = 2, height = 2;

	/**
	 * Constructor for SpaceStation building.
	 * @param Position The position of the building.
	 */
	public SpaceStation(Coordinate Position) {
		super(Position, defaultImage, cost, width, height);
        score = 9999;
	}

}

