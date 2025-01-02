package com.vikingz.headless.UI.Screens;

import org.junit.jupiter.api.BeforeAll;

import com.badlogic.gdx.Screen;
import com.vikingz.UI.Screens.EndScreen;
import com.vikingz.UI.Screens.GameplayScreen;
import com.vikingz.UI.Screens.LeaderboardScreen;
import com.vikingz.UI.Screens.SettingsScreen;
import com.vikingz.UI.Screens.StartScreen;

public class ScreensTest {
    

    Screen end, game, leaderboard, settings, start;


    @BeforeAll
    void testCreateScreen(){

        end = new EndScreen();
        game = new GameplayScreen();
        leaderboard = new LeaderboardScreen();
        settings = new SettingsScreen();
        start = new StartScreen();
    }



}
