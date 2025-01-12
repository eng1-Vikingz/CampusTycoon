package com.vikingz.campustycoon.Game.Buildings;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.UI.Components.MapBuilding;
import com.vikingz.campustycoon.UI.Components.Component.Anchor;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
 * The Building class represents a building in the game.
 * It provides properties and behaviors for all buildings in the game.
 * This class includes methods to increment the building counter and constructors to initialize the building.
 */
public class Building {
	public String buildingName = "null"; // Used in the BuildingCounter
	public MapBuilding drawInfo;
	public Coordinate position;
	public int width, height;
    public int cost;
    public int score;

	/**
	 * Constructs a building with the default position (0, 0).
	 * The default building is a 1x1 building with a cost of 100.
	 */
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

	/**
	 * Constructs a building with the specified position.
	 * @param Position The coordinate position of the building.
	 */
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

	/**
	 * Constructs a building with the specified position, image path, cost, width, and height.
	 * @param Position The coordinate position of the building.
	 * @param ImagePath The path to the image file for the building.
	 * @param Cost The cost of the building.
	 * @param Width The width of the building.
	 * @param Height The height of the building.
	 */
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


	/**
	 * Sets the position of the building.
	 * @param Position
	 */
	public void setPosition(Coordinate Position) {
		position = Position;
		drawInfo.setGridCoordinates(position.x, position.y);
	}

	/**
	 * Increments the building counter for the building by 1.
	 */
	public void incrementBuildingCounter() {
		BuildingCounter.increaseBuildingCounter(buildingName, 1);
	}

    /**
     * Decrement the building counter for the building by 1.
     */
    public void decrementBuildingCounter() {
        BuildingCounter.decreaseBuildingCounter(buildingName, 1);
    }
}
