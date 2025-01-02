package com.vikingz.Game.Tiles;


public interface Tile {
	
	// The Width and Length of any sprite
	static final int SpriteSize = 64; 
	
	// Spritemap is a 12x12 grid of 64x64 sprites
	static final int SpriteMapSize = 12;
	
	public int getTileID();
	
}
