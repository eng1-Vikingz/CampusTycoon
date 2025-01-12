package com.vikingz.campustycoon.Util;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.vikingz.campustycoon.UI.Screens.*;

/**
 * This class is used to switch between screens.
 */
public final class ScreenUtils {
    public static boolean GameActive = false;
	public static Screen currentScreen;
	public static Screen startScreen = new StartScreen();
	public static Screen gameplayScreen = new GameplayScreen();
	public static Screen endScreen = new EndScreen();

	public static LeaderboardScreen leaderboardScreen = new LeaderboardScreen();
    public static AchievementScreen achievementScreen = new AchievementScreen();
    public static SettingsScreen settingsScreen = new SettingsScreen();

	public static Game game;

	/**
	 * Changes the current screen to the gameplay screen.
	 */
	public static void openGameplayScreen() {
		currentScreen = gameplayScreen;
	}

	/**
	 * Changes the current screen to the end screen
	 */
	public static void OpenEndScreen() {
		currentScreen = endScreen;
        com.vikingz.campustycoon.Util.ScreenUtils.GameActive = false;
	}

	/**
	 * Opens the start screen
	 */
	public static void OpenStartScreen() {
		currentScreen = startScreen;
	}


	/**
	 * Opens the leaderboard screen
	 */
	public static void openLeaderboardScreen(){
		//game.setScreen(leaderboardScreen);
		leaderboardScreen.updateEntries();
		leaderboardScreen.setupTopFive();
		currentScreen = leaderboardScreen;
		leaderboardScreen.takeInput();
	}

	/**
	 * Opens the achievement screen
	 */
    public static void openAchievementScreen(){
        currentScreen = achievementScreen;
        achievementScreen.takeInput();
    }

	/**
	 * Opens the settings screen
	 */
    public static void openSettingsScreen(){
        currentScreen = settingsScreen;
        settingsScreen.takeInput();
    }

	/**
	 * Resets the input processor to the default input handler.
	 */
	public static void resetInputProcessor(){
		Gdx.input.setInputProcessor(new InputHandler());

	}
}
