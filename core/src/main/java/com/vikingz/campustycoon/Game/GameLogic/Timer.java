package com.vikingz.campustycoon.Game.GameLogic;

import com.vikingz.campustycoon.UI.Components.MenuText;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.ScreenUtils;


/**
 * This class is used to create a timer.
 */
public class Timer{
	public static MenuText text;
    private static float timeRemaining;
    private boolean isRunning;
    private boolean hasEnded;

    /**
     * Constructor for Timer. 
     * @param startTime The time to start the timer at.
     */
    public Timer(float startTime) {
        Timer.timeRemaining = startTime;
        this.isRunning = false;
        this.hasEnded = false;
    }
    
    /**
     * Starts the timer.
     */
    public void start() {
        isRunning = true;
        hasEnded = false; // Reset if the timer is restarted
    }
    
    /**
     * Pauses the timer.
     */
    public void pause() {
        isRunning = false;
    }
    
    /**
     * Resets the timer.
     * @param startTime The time to reset the timer to.
     */
    public void reset(float startTime) {
        Timer.timeRemaining = startTime;
        this.isRunning = false;
        this.hasEnded = false;
    }
    
    /**
     *  Updates the timer.
     * @param deltaTime The time since the last update.
     */
    public void update(float deltaTime) {
        if (isRunning && timeRemaining > 0) {
            timeRemaining -= deltaTime;
            if (timeRemaining <= 0) {
                timeRemaining = 0;
                onTimeUp(); // Call onTimeUp to handle end logic
            }
			
			if (text != null) {
				text.text = floatToMinSec(timeRemaining);
				text.update();
			}
        }
    }

    /**
     * Converts a float to a string in the format of minutes and seconds.
     * @param secs The time in seconds.
     * @return The time in the format of minutes and seconds.
     */
    private String floatToMinSec(float secs){
        
        int m = Math.round(secs / 60);
        int s = Math.round(secs % 60);

        if(m > 100000){
            return null;
        }

        return "Time: " + String.format("%02d", m) + ":" + String.format("%02d", s);
        
    
    }
    
    /**
     * Gets the time remaining.
     * @return The time remaining.
     */
    public static float getTimeRemaining() {
        return timeRemaining;
    }

    /**
     * Checks if the timer has ended.
     * @return If the timer has ended.
     */
    public boolean hasEnded() {
        return hasEnded;
    }

    /**
     * Initialises end timer logic.
     */
    private void onTimeUp() {
        if (!hasEnded) { // Check if already ended to avoid repeating
            hasEnded = true;
            isRunning = false; // Stop the timer completely

            Drawer.clear();
            ScreenUtils.OpenEndScreen();
			BuildingCounter.reset();
        }
    }

    /**
     * Checks if the timer is running.
     * @return If the timer is running.
     */
    public boolean isRunning() {
        return isRunning;
    }
}