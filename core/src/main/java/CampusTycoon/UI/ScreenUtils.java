package CampusTycoon.UI;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import CampusTycoon.InputHandler;

public final class ScreenUtils {
	public static Screen currentScreen;
	
	public static Screen startScreen = new StartScreen();
	public static Screen gameplayScreen = new GameplayScreen();
	public static Screen endScreen = new EndScreen();

	public static LeaderboardScreen leaderboardScreen = new LeaderboardScreen();
	
	public static Game game;
	
	public static void openGameplayScreen() {
		currentScreen = gameplayScreen;
	}

	public static void OpenEndScreen() {
		currentScreen = endScreen;
	}

	public static void OpenStartScreen() {
		currentScreen = startScreen;
	}

	public static void openLeaderboardScreen(){
		//game.setScreen(leaderboardScreen);
		currentScreen = leaderboardScreen;
		leaderboardScreen.takeInput();
	}

	public static void resetInputProcessor(){
		Gdx.input.setInputProcessor(new InputHandler());

	}
}
