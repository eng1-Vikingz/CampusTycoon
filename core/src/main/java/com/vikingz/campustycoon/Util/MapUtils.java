package com.vikingz.campustycoon.Util;

import java.util.ArrayList;

import com.vikingz.campustycoon.Game.Buildings.*;
import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.Game.Maps.York;
import com.vikingz.campustycoon.Game.Tiles.*;
import com.vikingz.campustycoon.UI.Camera;
import com.vikingz.campustycoon.Util.Types.Coordinate;

/**
 * Utility class for handling maps.
 */
public class MapUtils {
	private Map map;

	public MapUtils(Map Map) {
		map = Map;
	}

	/**
	 * Placement
	 * Contains the different types of buildings that can be placed
	 */
	public abstract class Placement {
		public static final String AccommodationBuilding = "ACCOMMODATION";
		public static final String StudyBuilding = "STUDY";
		public static final String StudyBuilding2 = "STUDY2";
		public static final String CafeteriaBuilding = "CAFETERIA";
		public static final String RelaxationBuilding = "RELAXATION";
		public static final String RelaxationBuilding2 = "RELAXATION2";
		public static final String Road = "ROAD"; // Most definitely not implemented yet
	}


	/**
	 * CHANGED
	 *
	 * To create a new building, i created a new {@class Placement} which
	 * just loads a different texture for the study building.
	 *
	 * TODO:
	 * Do the same for the other types of buildings as for study
	 *
	 * @param buildingType
	 * @return
	 */
	public static Building getBuilding(String buildingType) {
		switch (buildingType) {
			case Placement.AccommodationBuilding:
				return new Accommodation();

			case Placement.StudyBuilding:
				return new Study(0);

			case Placement.StudyBuilding2:
				return new Study(1);

			case Placement.CafeteriaBuilding:
				return new Cafeteria();

			case Placement.RelaxationBuilding:
				return new Relaxation(0);

		    case Placement.RelaxationBuilding2:
				return new Relaxation(1);
			default:
				return new Building();
		}
	}

	/**
	 * Checks it a building can be placed at a given position
	 * @param newBuilding
	 * @return
	 */
	public boolean buildingPlaceable(Building newBuilding) {
		for (Building Building : Map.buildings) {
			Coordinate b = Building.position;
			Coordinate newPos = newBuilding.position;

			// Checks if the position of the new building would cause any part of itself to overlap with an existing building
			if (newPos.x + newBuilding.width - 1 >= b.x && newPos.x < b.x + Building.width &&
				newPos.y + newBuilding.height - 1 >= b.y && newPos.y < b.y + Building.height) {
					return false;
				}
		}
        for (int x=0; x < newBuilding.width; x++){
            for (int y=0; y < newBuilding.height;y++){
                //Checks for placing over water
                //System.out.println(Camera.getTileFromCoords(newBuilding.position.x+x,newBuilding.position.y+y));
                if (Camera.getTileFromCoords(newBuilding.position.x+x,newBuilding.position.y+y).getTileID() == 1){
                    return false;
                }
            }
        }
		return true;
	}

    public Building CloseToBuilding(Coordinate pos){
        for (Building Building : Map.buildings) {
            Coordinate b = Building.position;
            if (Math.abs(b.x - pos.x) <= 2 && Math.abs(b.y - pos.y) <= 2 ){
                return Building;
            }
        }
        return null;
    }




	/**
	 * Checks if a building occupies the current tile space
	 * @param tile
	 * @return
	 */
	public boolean tileHasBuilding(Coordinate tile) {
		for (Building building : Map.buildings) {
			Coordinate pos = building.position;

			if (tile.x >= pos.x && tile.x < pos.x + building.width &&
				tile.y >= pos.y && tile.y < pos.y + building.height) {
					return true;
				}
		}

		return false;
	}

	/**
	 * Checks if location is outside the map
	 * @param tile
	 * @return
	 */
	public boolean outsideMap(Coordinate tile) {
		if (tile.x >= map.width || tile.x < 0 ||
				tile.y >= map.height || tile.y < 0) {
			return true;
		}
		return false;
	}


	/**
	 * Initialises the buildings on the map
	 */
	public void initialiseBuildings() {
		Map.buildings = new ArrayList<Building>();


		// Forcefully enables placement mode
		//map.placing = true;

		// Adds a few different buildings to the map
		map.placementType = Placement.CafeteriaBuilding;
		map.placeBuildingBypass(new Coordinate(4, 5));

		map.placementType = Placement.StudyBuilding;
		map.placeBuildingBypass(new Coordinate(10, 13));


		map.placementType = Placement.AccommodationBuilding;
		map.placeBuildingBypass(new Coordinate(23, 14));
	}

	/**
	 * Initialises the grid of the map
	 */
	public void initialiseGrid() {
		// Read map file from somewhere
		// Format:
		// 		width height
		//		mapTileID
		// e.g. 3 3
		//		0 0 1
		//		0 1 1
		// 		1 2 1

		String content = "";
		try {
			//byte[] byteContent = getClass().getResourceAsStream(Map.defaultMap).readAllBytes();
			//content = new String(byteContent, StandardCharsets.UTF_8);
			content = York.RawMap;
		}
		catch (Exception e) { }

		String[] lines = content.split("\n");

		String[] size = lines[0].split(" ");
		map.width = Integer.parseInt(size[0].toString().strip());
		map.height = Integer.parseInt(size[1].toString().strip());

		map.grid = new ArrayList<ArrayList<Tile>>(map.height);

		for (int i = 0; i < map.height; i++) {
			ArrayList<Tile> row = new ArrayList<Tile>(map.width);
			String[] tiles = lines[1 + i].split(" ");
			for (int j = 0; j < map.width; j++) {
				Tile tile = getTile(Integer.parseInt(tiles[j].strip()));
				row.add(tile);
			}
		map.grid.add(row);
		}
	}

	/**
	 * Gets a tile from the tile ID
	 * @param tileID
	 * @return
	 */
	public Tile getTile(int tileID) {
		Tile tile;
		switch (tileID) {
			case 0:
				tile = new Grass();
				break;
			case 1:
				tile = new Lake();
				break;
			case 2:
				tile = new Mountain();
				break;
			default:
				System.out.println("Unknown tile ID: \"" + tileID + "\"");
				tile = null;
		}
		return tile;
	}
}
