package com.vikingz.campustycoon.UI.Components;

import java.util.List;

/**
 * This class is used to create a backdrop.
 * 
 * Pretty trivial, simply uses the {@class Component} class to create a backdrop.
 */
public class Backdrop extends Component {


    /**
     * Constructor for the Backdrop class.
     * @param X 
     * @param Y 
     * @param Width
     * @param Height
     */
	public Backdrop(float X, float Y, float Width, float Height) {
		super(X, Y, Width, Height);
	}

    /**
     * Constructor for the Backdrop class.
     * @param imagePath 
     * @param X
     * @param Y
     * @param Width
     * @param Height
     */
	public Backdrop(String imagePath, float X, float Y, float Width, float Height) {
		super(imagePath, X, Y, Width, Height);
	}

    /**
     * Constructor for the Backdrop class.
     * @param imagePaths
     * @param X
     * @param Y
     * @param Width
     * @param Height
     */
	public Backdrop(List<String> imagePaths, float X, float Y, float Width, float Height) {
		super(imagePaths, X, Y, Width, Height);
	}

	public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

	public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }
	
	
	
	// Not needed as backdrop elements don't need to do anything on click
	@Override
	public void setClickAction(String action) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setClickAction'");
	}
}