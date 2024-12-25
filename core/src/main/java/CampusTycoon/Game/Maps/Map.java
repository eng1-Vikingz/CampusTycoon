package CampusTycoon.Game.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import CampusTycoon.Game.Buildings.*;
import CampusTycoon.Game.GameLogic.MoneyHandler;
import CampusTycoon.Game.GameLogic.SatisfactionMeter;
import CampusTycoon.Game.Tiles.*;
import CampusTycoon.UI.Components.BankruptMenu;
import CampusTycoon.UI.Screens.GameplayScreen;
import CampusTycoon.UI.Systems.BuildingDisplay;
import CampusTycoon.UI.Systems.MapDisplay;
import CampusTycoon.Util.Drawer;
import CampusTycoon.Util.GameSounds;
import CampusTycoon.Util.MapUtils;
import CampusTycoon.Util.ScreenUtils;
import CampusTycoon.Util.Types.Coordinate;

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

	public Map() {
		mapUtils = new MapUtils(this);
		mapUtils.initialiseGrid();
		mapUtils.initialiseBuildings();

		display = new MapDisplay(this);
		display.drawMap();
		buildingDisplay = new BuildingDisplay(buildings);
		buildingDisplay.drawBuildings();
	}

	public void toggleBuildingPlacement(String building) {
		if (placementType == building) {
			this.placing = !placing;
			return;
		}

		this.placementType = building;
		this.placing = true;
	}

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
