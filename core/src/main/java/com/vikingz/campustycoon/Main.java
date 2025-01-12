package com.vikingz.campustycoon;

import com.vikingz.campustycoon.Util.GameMusic;
import com.vikingz.campustycoon.Util.GameSounds;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.vikingz.campustycoon.Game.GameLogic.EventLoader;
import com.vikingz.campustycoon.UI.Screens.StartScreen;
import com.vikingz.campustycoon.Util.InputHandler;
import com.vikingz.campustycoon.Util.ScreenUtils;

/**
 * Main entry point for the game.
 */
/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Override
    public void create() {
		//Gdx.graphics.setForegroundFPS(60); // Useful function for settings menu later
        //Gdx.graphics.setContinuousRendering(false); // Interesting function to explore later
        //(^if rendering performance becomes an issue)


        Gdx.graphics.setTitle("Campus Tycoon");
        Gdx.input.setInputProcessor(new InputHandler());


        //Loads events
        new EventLoader("event.yml");

        //Initialises Music and starts Music
        new GameMusic();
        GameMusic.play();

        //Initialise Sounds and starts Sounds
        new GameSounds();


		// Sets the screen to the Main Menu
		Screen screen = new StartScreen();
		ScreenUtils.currentScreen = screen;
		setScreen(screen);
	}

    /**
     * Renders the game.
     */
	@Override
	public void render () {

		if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
		if (ScreenUtils.currentScreen != screen) { setScreen(ScreenUtils.currentScreen); }
	}

}
