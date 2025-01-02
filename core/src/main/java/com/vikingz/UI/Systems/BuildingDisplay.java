package com.vikingz.UI.Systems;

import java.util.List;

import com.vikingz.Game.Buildings.Building;
import com.vikingz.Util.Drawer;

public class BuildingDisplay {
	public static final int Layer = -1;
	
	public List<Building> buildings;
	
	public BuildingDisplay(List<Building> Buildings) {
		buildings = Buildings;
	}
	
	public void drawBuildings() {
		for (Building building : buildings) {
			Drawer.add(Layer, building.drawInfo);
		}
	}
}

