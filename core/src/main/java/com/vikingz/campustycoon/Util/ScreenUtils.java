package com.vikingz.campustycoon.Util;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.vikingz.campustycoon.UI.Screens.*;

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

	public static void openGameplayScreen() {
		currentScreen = gameplayScreen;
	}

	public static void OpenEndScreen() {
		currentScreen = endScreen;
        com.vikingz.campustycoon.Util.ScreenUtils.GameActive = false;
	}

	public static void OpenStartScreen() {
		currentScreen = startScreen;
	}


	public static void openLeaderboardScreen(){
		//game.setScreen(leaderboardScreen);
		leaderboardScreen.updateEntries();
		leaderboardScreen.setupTopFive();
		currentScreen = leaderboardScreen;
		leaderboardScreen.takeInput();
	}

    public static void openAchievementScreen(){
        currentScreen = achievementScreen;
        achievementScreen.takeInput();
    }
    public static void openSettingsScreen(){
        currentScreen = settingsScreen;
        settingsScreen.takeInput();
    }


	public static void resetInputProcessor(){
		Gdx.input.setInputProcessor(new InputHandler());

	}
}
