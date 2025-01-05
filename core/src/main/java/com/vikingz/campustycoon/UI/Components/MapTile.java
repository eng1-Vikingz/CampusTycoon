package com.vikingz.campustycoon.UI.Components;

/**
 * This class is used to create a map tile.
 */
public class MapTile extends Component {

	private int mapHeight;
	public int gridX, gridY;
	
	/**
	 * Constructor for the MapTile class.
	 * @param SpriteSheet
	 * @param TileID
	 * @param X
	 * @param Y
	 * @param Width
	 * @param Height
	 */
	public MapTile(SpriteSheet SpriteSheet, int TileID, float X, float Y, float Width, float Height) {
		super(SpriteSheet, TileID, X, Y, Width, Height);
	}

	/**
	 * Constructor for the MapTile class.
	 * @param SpriteSheet
	 * @param TileID
	 * @param X
	 * @param Y
	 */
	public MapTile(SpriteSheet SpriteSheet, int TileID, float X, float Y) {
		super(SpriteSheet, TileID, X, Y, SpriteSheet.spriteWidth, SpriteSheet.spriteHeight);
	}

	/**
	 * Constructor for the MapTile class.
	 * @param SpriteSheet
	 * @param TileID
	 * @param X
	 * @param Y
	 * @param GridX
	 * @param GridY
	 * @param MapHeight
	 */
	public MapTile(SpriteSheet SpriteSheet, int TileID, float X, float Y, int GridX, int GridY, int MapHeight) {
		super(SpriteSheet, TileID, X, Y, SpriteSheet.spriteWidth, SpriteSheet.spriteHeight);
		mapHeight = MapHeight;
		gridX = GridX;
		gridY = GridY;
	}

	/**
	 * Constructor for the MapTile class.
	 * Creates a defualt tile with values set to 0.
	 */
	public MapTile() {
		super(0, 0, 0, 0);
	}
	

	/**
	 * Applies zoom
	 */
	public void applyZoomOffset() {
		this.baseX = this.offsetX + getBaseWidth() * this.gridX;
		this.baseY = this.offsetY + getBaseHeight() * (mapHeight - 1 - this.gridY);
		update();
	}
	
	@Override
	public void setClickAction(String action) {
		throw new UnsupportedOperationException("Unimplemented method 'setClickAction'");
	}
}
