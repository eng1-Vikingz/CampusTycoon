package com.vikingz.Game.Buildings;

import com.vikingz.Game.GameLogic.BuildingCounter;
import com.vikingz.Util.Types.Coordinate;

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
