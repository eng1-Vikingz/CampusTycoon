package com.vikingz.campustycoon.UI.Systems;

import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.Game.Tiles.Tile;
import com.vikingz.campustycoon.UI.Camera;
import com.vikingz.campustycoon.UI.Components.MapTile;
import com.vikingz.campustycoon.UI.Components.SpriteSheet;
import com.vikingz.campustycoon.UI.Components.Component.Anchor;
import com.vikingz.campustycoon.Util.Drawer;

import java.util.List;

/**
 * This class is used to display the map.
 */
public class MapDisplay {
	public static final int Layer = -2;
	private Map map;
	private SpriteSheet spriteSheet;
	
	/**
	 * Constructor for the MapDisplay class.
	 * @param Map
	 */
	public MapDisplay(Map Map) {
		map = Map;
		initialise();
	}
	
	/**
	 * Draw the map to the screen.
	 */
	public void drawMap() {
		for (int row = 0; row < map.height; row++) {
			List<Tile> mapRow = map.grid.get(row);
			for (int col = 0; col < map.width; col++) {
				Tile tile = mapRow.get(col);
				MapTile drawTile = new MapTile(
					spriteSheet, 
					tile.getTileID(), 
					getX(col), getY(row),
					col, row,
					map.height);
				drawTile.setAnchor(Anchor.BottomLeft);
				Drawer.add(Layer, drawTile);
			}
		}
	}
	
	/**
	 * Get the x position
	 * @param x
	 * @return
	 */
	private int getX(int x) {
		return (int)(spriteSheet.spriteWidth * x * Camera.zoom);
	}
	
	/**
	 * Get the y position
	 * @param y
	 * @return
	 */
	private int getY(int y) {
		return (int)(spriteSheet.spriteHeight * (map.height - 1 - y) * Camera.zoom);
	}
	
	/**
	 * Initialise the map display.
	 */
	private void initialise() {
		spriteSheet = new SpriteSheet(
			"Tiles\\SpriteMap.png", 
			12, 12, 
			Tile.SpriteSize, Tile.SpriteSize);
	}
}