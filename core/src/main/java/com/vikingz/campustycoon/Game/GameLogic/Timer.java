package com.vikingz.campustycoon.Game.GameLogic;

import com.vikingz.campustycoon.UI.Components.MenuText;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.ScreenUtils;


public class Timer{
	public static MenuText text;
    private static float timeRemaining;
    private boolean isRunning;
    private boolean hasEnded;

    
    public Timer(float startTime) {
        this.timeRemaining = startTime;
        this.isRunning = false;
        this.hasEnded = false;
    }
    
    public void start() {
        isRunning = true;
        hasEnded = false; // Reset if the timer is restarted
    }
    
    public void pause() {
        isRunning = false;
    }
    
    public void reset(float startTime) {
        this.timeRemaining = startTime;
        this.isRunning = false;
        this.hasEnded = false;
    }
    
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

    private String floatToMinSec(float secs){
        
        int m = Math.round(secs/ 60);
        int s = Math.round(secs % 60);

        if(m > 100000){
            return null;
        }

        return "Time: " + String.format("%02d", m) + ":" + String.format("%02d", s);
        
    
    }
    
    public static float getTimeRemaining() {
        return timeRemaining;
    }

    public boolean hasEnded() {
        return hasEnded;
    }

    private void onTimeUp() {
        if (!hasEnded) { // Check if already ended to avoid repeating
            hasEnded = true;
            isRunning = false; // Stop the timer completely

            Drawer.clear();
            ScreenUtils.OpenEndScreen();
			BuildingCounter.reset();
        }
    }
}