package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.BuildingCounter;
import CampusTycoon.GameLogic.Coordinate;

public class Relaxation extends Building {
	public static final String[] defaultImage = {"Buildings\\Relaxation.png", "Buildings\\Relaxation2.png"};
	public static final String buildingName = "Relaxation";
	public static final String buildingName2 = "Relaxation2";
    public static int cost = 200;
	public static int width = 3, height = 3;


	public Relaxation(Coordinate Position, int textureIndex) {
		super(Position, defaultImage[textureIndex],cost, width , height);
        score = 200;
	}
	public Relaxation(int textureIndex) {
		super(new Coordinate(0, 0), defaultImage[textureIndex],cost, width , height);
        score = 200;
	}


	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
