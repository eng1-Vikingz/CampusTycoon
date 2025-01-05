package com.vikingz.campustycoon.Util.Types;

// A simple class to enable easier passing of coordinate pairs (commonly needed for spritesheets)
public class CoordinatePair {
	public Coordinate start, end;
	
	/**
	 * Constructor for the CoordinatePair class.
	 * Initial values for start and end are 0.
	 */
	public CoordinatePair() {
		start = new Coordinate();
		end = new Coordinate();
	}
	
	/**
	 * Constructor for the CoordinatePair class.
	 * @param Start Start coordinate
	 * @param End End coordinate
	 */
	public CoordinatePair(Coordinate Start, Coordinate End) {
		start = Start;
		end = End;
	}
}
