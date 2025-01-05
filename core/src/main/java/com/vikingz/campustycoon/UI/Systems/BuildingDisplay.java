package com.vikingz.campustycoon.UI.Systems;

import java.util.List;

import com.vikingz.campustycoon.Game.Buildings.Building;
import com.vikingz.campustycoon.Util.Drawer;

/**
 * This class is used to display buildings.
 */
public class BuildingDisplay {
	
	public static final int Layer = -1;
	public List<Building> buildings;
	
	/**
	 * Constructor for the BuildingDisplay class.
	 * @param Buildings List of buildings in the game.
	 */
	public BuildingDisplay(List<Building> Buildings) {
		buildings = Buildings;
	}
	
	/**
	 * Draw all the buildings to the screen.
	 */
	public void drawBuildings() {
		for (Building building : buildings) {
			Drawer.add(Layer, building.drawInfo);
		}
	}
}

