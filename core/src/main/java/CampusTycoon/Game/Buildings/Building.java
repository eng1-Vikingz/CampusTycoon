package CampusTycoon.Buildings;

import CampusTycoon.GameLogic.BuildingCounter;
import CampusTycoon.UI.Components.MapBuilding;
import CampusTycoon.UI.Components.Component.Anchor;
import CampusTycoon.Util.Types.Coordinate;

public class Building {
	public String buildingName = "null"; // Used in the BuildingCounter
	public MapBuilding drawInfo;
	public Coordinate position;
	public int width, height;
    public int cost;
    public int score;

	public Building() {
		width = 1;
		height = 1;
        cost =100;
		position = new Coordinate(0, 0);
		drawInfo = new MapBuilding(
			"MissingTexture.png",
			position.x, position.y);
		drawInfo.setAnchor(Anchor.BottomLeft);
	}
	public Building(Coordinate Position) {
		width = 1;
		height = 1;
        cost =100;
		position = Position;
		drawInfo = new MapBuilding(
			"MissingTexture.png",
			position.x, position.y);
		drawInfo.setAnchor(Anchor.BottomLeft);
	}
	protected Building(Coordinate Position, String ImagePath,int Cost,int Width, int Height) {
		position = Position;
		width = Width;
		height = Height;
        cost = Cost;
		drawInfo = new MapBuilding(
			ImagePath,
			position.x, position.y,
			Width, Height);
		drawInfo.setAnchor(Anchor.BottomLeft);
	}


	public void setPosition(Coordinate Position) {
		position = Position;
		drawInfo.setGridCoordinates(position.x, position.y);
	}

	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}
}
