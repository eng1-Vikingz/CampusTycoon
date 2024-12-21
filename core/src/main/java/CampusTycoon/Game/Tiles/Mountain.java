package CampusTycoon.Tiles;

public class Mountain implements Tile {
	@Override
	public int getTileID() { return 2; }
	
	@Override
	public String debugMessage() {
		return "I am rock!";
	}
}