package CampusTycoon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import CampusTycoon.GameLogic.EventLoader;
import CampusTycoon.UI.Screens.StartScreen;
import CampusTycoon.Util.InputHandler;
import CampusTycoon.Util.ScreenUtils;

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
        new EventLoader();


		// Sets the screen to the Main Menu
		Screen screen = new StartScreen();
		ScreenUtils.currentScreen = screen;
		setScreen(screen);
	}

	@Override
	public void render () {



		if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
		if (ScreenUtils.currentScreen != screen) { setScreen(ScreenUtils.currentScreen); }
	}

}
