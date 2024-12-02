package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.BuildingCounter;
import CampusTycoon.GameLogic.Coordinate;

public class Relaxation extends Building {
	public static final String[] defaultImage = {"Buildings\\Relaxation.png", "Buildings\\Relaxation2.png"};
	public static final String buildingName = "Relaxation";
	public static final String buildingName2 = "Relaxation2";
	public static int width = 3, height = 3;
	
	public Relaxation(Coordinate Position, int textureIndex) {
		super(Position, defaultImage[textureIndex], width , height);
	}
	public Relaxation(int textureIndex) {
		super(new Coordinate(0, 0), defaultImage[textureIndex], width , height);
	}
	
	
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
