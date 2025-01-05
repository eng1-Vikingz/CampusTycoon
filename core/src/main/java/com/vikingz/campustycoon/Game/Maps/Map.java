package com.vikingz.campustycoon.Game.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vikingz.campustycoon.Game.Buildings.*;
import com.vikingz.campustycoon.Game.GameLogic.MoneyHandler;
import com.vikingz.campustycoon.Game.GameLogic.SatisfactionMeter;
import com.vikingz.campustycoon.Game.Tiles.*;
import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.UI.Systems.BuildingDisplay;
import com.vikingz.campustycoon.UI.Systems.MapDisplay;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.GameSounds;
import com.vikingz.campustycoon.Util.MapUtils;
import com.vikingz.campustycoon.Util.ScreenUtils;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
 * This class is used to create a map.
 */
public class Map {
	public static String defaultMap = "York.txt";

	public ArrayList<ArrayList<Tile>> grid;
	public int width, height;
	public Random rng = new Random();

	public static List<Building> buildings = new ArrayList<Building>();

	private MapDisplay display;
	public BuildingDisplay buildingDisplay;
	private MapUtils mapUtils;

	public boolean placing;
	public String placementType;

	/**
	 * Constructor for the Map class.
	 */
	public Map() {
		mapUtils = new MapUtils(this);
		mapUtils.initialiseGrid();
		mapUtils.initialiseBuildings();

		display = new MapDisplay(this);
		display.drawMap();
		buildingDisplay = new BuildingDisplay(buildings);
		buildingDisplay.drawBuildings();
	}

	/**
	 * Toggles the ability to place a building.
	 * @param building
	 */
	public void toggleBuildingPlacement(String building) {
		if (placementType == building) {
			this.placing = !placing;
			return;
		}

		this.placementType = building;
		this.placing = true;
	}

	/**
	 * Places a building on the map, bypassing the user.
	 * @param position The position to place the building.
	 */
    public void placeBuildingBypass(Coordinate position){
        if (!placing) {
            return; // Placement mode currently toggled off
        }
        Building building = MapUtils.getBuilding(placementType);
        building.setPosition(position);
        building.buildingName = placementType.replaceAll("\\d","");
        building.score = MapUtils.getBuilding(placementType).score;

        //Adds building
        buildings.add(building);
        Drawer.add(-1, building.drawInfo);

        building.incrementBuildingCounter(); // Number go up (by 1)
        SatisfactionMeter.updateSatisfactionScore(); // Placing buildings satisfies students!!!

    }

	/**
	 * Places a building on the map.
	 * @param position The position to place the building.
	 */
	public void placeBuilding(Coordinate position) {
		if (!placing) {
			return; // Placement mode currently toggled off
		}

		Building building = MapUtils.getBuilding(placementType);
		building.setPosition(position);
		placing = false;
		if (!mapUtils.buildingPlaceable(building)) {
            GameSounds.playPlaceError();
			return; // Building location invalid
		}

		if (mapUtils.outsideMap(position)) {
			// Tried to place a building in the void, so places a space station instead
			building = new SpaceStation(position);
            GameSounds.playPlaceError();
		}

        if (!MoneyHandler.addMoney(-building.cost)){
            ((GameplayScreen) ScreenUtils.gameplayScreen).displayBankruptWarning();
            GameSounds.playPlaceError();
            return; //no money
        }

		// Else if placing and building location valid:
		buildings.add(building);
        building.buildingName = placementType.replaceAll("\\d","");
        System.out.println("Score: " + MapUtils.getBuilding(placementType).score);
        building.score = MapUtils.getBuilding(placementType).score;
		Drawer.add(-1, building.drawInfo);

		building.incrementBuildingCounter(); // Number go up (by 1)

		SatisfactionMeter.updateSatisfactionScore(); // Placing buildings satisfies students!!!
        GameSounds.playPlacedBuilding();
	}
}
