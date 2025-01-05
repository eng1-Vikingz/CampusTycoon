package com.vikingz.campustycoon.UI.Components;

/**
 * Creates a menu test component.
 */
public class MenuText extends Component {

	/**
	 * Constructor for the MenuText class.
	 * @param text
	 * @param X
	 * @param Y
	 * @param WidthScale
	 * @param HeightScale
	 */
	public MenuText(String text, float X, float Y, float WidthScale, float HeightScale) {
		super(X, Y, WidthScale, HeightScale);
		
		this.text = text;
		this.isText = true;
	}

	
	
	// Not needed as text elements don't need to do anything on click
	@Override
	public void setClickAction(String action) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setClickAction'");
	}
}

