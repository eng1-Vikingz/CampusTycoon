package com.vikingz.campustycoon.Util.Types;

/**
 * This class is used to create a coordinate.
 */
public class Coordinate {
	public int x, y;
	
	/**
	 * Constructor for the Coordinate class.
	 * Initial values for x and y are 0.
	 */
	public Coordinate() {
		x = 0; 
		y = 0;
	}
	
	/**
	 * Constructor for the Coordinate class.
	 * @param X x value
	 * @param Y	y value
	 */
	public Coordinate(int X, int Y) {
		x = X;
		y = Y;
	}
	
	/**
	 * Calcualtes the distange between two points.
	 * @param point The point to calculate the distance to.
	 * @return
	 */
	public double distance(Coordinate point) {
		double x = point.x - this.x;
		double y = point.y - this.y;
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Checks if 2 coordinates are equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Coordinate coord = (Coordinate) o;

		return (this.x == coord.x) && (this.y == coord.y);
		
	}
}
