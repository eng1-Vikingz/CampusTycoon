package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Util.Types.Coordinate;

public class Accommodation extends Building {
	public static final String defaultImage = "Buildings\\Accommodation.png";
	public static final String buildingName = "Accommodation";
    public static int cost = 200;
	public static int width = 3, height = 3;


	public Accommodation(Coordinate Position) {
		super(Position, defaultImage, cost, width , height);
        score = 200;
	}
	public Accommodation() {
		super(new Coordinate(0, 0), defaultImage, cost, width , height);
        score = 200;
	}


	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
