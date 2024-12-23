package CampusTycoon.UI.Systems;

import java.util.List;

import CampusTycoon.Game.Buildings.Building;
import CampusTycoon.Util.Drawer;

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
