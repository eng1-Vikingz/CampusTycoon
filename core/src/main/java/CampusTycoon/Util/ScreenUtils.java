package CampusTycoon.Util;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import CampusTycoon.UI.Screens.EndScreen;
import CampusTycoon.UI.Screens.GameplayScreen;
import CampusTycoon.UI.Screens.LeaderboardScreen;
import CampusTycoon.UI.Screens.SettingsScreen;
import CampusTycoon.UI.Screens.StartScreen;

public final class ScreenUtils {
    public static boolean GameActive = false;
	public static Screen currentScreen;
	public static Screen startScreen = new StartScreen();
	public static Screen gameplayScreen = new GameplayScreen();
	public static Screen endScreen = new EndScreen();

	public static LeaderboardScreen leaderboardScreen = new LeaderboardScreen();
    public static SettingsScreen settingsScreen = new SettingsScreen();

	public static Game game;

	public static void openGameplayScreen() {
		currentScreen = gameplayScreen;
	}

	public static void OpenEndScreen() {
		currentScreen = endScreen;
        CampusTycoon.Util.ScreenUtils.GameActive = false;
	}

	public static void OpenStartScreen() {
		currentScreen = startScreen;
	}


	public static void openLeaderboardScreen(){
		//game.setScreen(leaderboardScreen);
		currentScreen = leaderboardScreen;
		leaderboardScreen.takeInput();
	}
    public static void openSettingsScreen(){
        currentScreen = settingsScreen;
        settingsScreen.takeInput();
    }


	public static void resetInputProcessor(){
		Gdx.input.setInputProcessor(new InputHandler());

	}
}
