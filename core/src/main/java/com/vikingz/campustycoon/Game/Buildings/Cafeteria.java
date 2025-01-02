package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Util.Types.Coordinate;

public class Cafeteria extends Building {
	public static final String defaultImage = "Buildings\\Cafeteria.png";
	public static final String buildingName = "Cafeteria";
    public static int cost = 100;
	public static int width = 3, height = 3;


	public Cafeteria(Coordinate Position) {
		super(Position, defaultImage, cost,width , height);
        score = 300;
	}
	public Cafeteria() {
		super(new Coordinate(0, 0), defaultImage, cost, width , height);
        score = 300;
	}


	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
