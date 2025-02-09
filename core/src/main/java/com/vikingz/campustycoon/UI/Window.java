package com.vikingz.campustycoon.UI;

import com.vikingz.campustycoon.UI.Components.Component;

/**
 * This class is used to manage the window.
 */
public class Window {
	public static int defaultWidth = 1280; // Treat as a constant
	public static int defaultHeight = 720; // Do not ask me why they need to be specifically these values but just know that they do otherwise everything breaks
	public static int width = defaultWidth;
	public static int height = defaultHeight;
	
	/**
	 * Update the resolution of the window.
	 * @param ScreenWidth
	 * @param ScreenHeight
	 */
	public static void updateResolution(int ScreenWidth, int ScreenHeight) {
		width = ScreenWidth;
		height = ScreenHeight;
		Component.updateResolution();
	}
}