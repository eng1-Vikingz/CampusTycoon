package com.vikingz.Util.Types;

public class Tuple<X, Y> { 

	public final X x; 
	public final Y y; 


	public Tuple(X x, Y y) { 
	this.x = x; 
	this.y = y; 
	} 

	@Override
	public String toString() {

		String str = "[ " + x  + " : " + y +" ]";
		return str;
	}


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