package com.vikingz.campustycoon.Util.Types;

/**
 * This class is used to create a tuple.
 * Used to return pair of values that can have different
 * types.
 */
public class Tuple<X, Y> { 

	public final X x; 
	public final Y y; 

	/**
	 * Constructor for the Tuple class.
	 * @param x x value
	 * @param y y value
	 */
	public Tuple(X x, Y y) { 
	this.x = x; 
	this.y = y; 
	} 

	/**
	 * To String method for eaier degbugging.
	 */
	@Override
	public String toString() {

		String str = "[ " + x  + " : " + y +" ]";
		return str;
	}


	/**
	 * Checks if 2 tuples are equal.
	 * @param o The object to compare to.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Tuple<?, ?> tuple = (Tuple<?, ?>) o;

		return (x.equals(tuple.x) && y.equals(tuple.y));
	}




} 