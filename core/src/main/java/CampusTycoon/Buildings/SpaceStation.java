package CampusTycoon.Buildings;

import CampusTycoon.Util.Types.Coordinate;

// This "building" is used when you attempt to place something outside the map
// Should probably just not allow that to happen, but I think this is funnier
public class SpaceStation extends Building {
	public static final String defaultImage = "Buildings\\SpaceStation.png";
	public static final String buildingName = "SpaceStation";
    public static int cost = 0;
	public static int width = 2, height = 2;

	public SpaceStation(Coordinate Position) {
		super(Position, defaultImage, cost, width, height);
        score = 9999;
	}


	@Override
	public void incrementBuildingCounter() {
		// Do nothing because space stations are special
	}
}

