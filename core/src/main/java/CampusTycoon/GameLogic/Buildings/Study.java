package CampusTycoon.GameLogic.Buildings;

import CampusTycoon.GameLogic.BuildingCounter;
import CampusTycoon.GameLogic.Coordinate;

/**
 * CHANGED
 * 
 * This class was originally made so that it
 * had the path to the texture hard coded, so i changed it 
 * into an array where the user can change the texture based on 
 * the index of the array.
 */


public class Study extends Building{
	public static final String[] defaultImage = {"Buildings\\Study.png", "Buildings\\Study2.png"};
	public static final String buildingName = "Study";
	public static int width = 3, height = 3;
	
	public Study(Coordinate Position, int textureIndex) {
		super(Position, defaultImage[textureIndex], width , height);
	}
	public Study(int textureIndex) {
		super(new Coordinate(0, 0), defaultImage[textureIndex], width , height);
	}
	
	
	@Override
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
