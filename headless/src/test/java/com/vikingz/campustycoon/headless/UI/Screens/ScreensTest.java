package com.vikingz.campustycoon.headless.UI.Screens;

import org.junit.jupiter.api.BeforeAll;

import com.badlogic.gdx.Screen;
import com.vikingz.campustycoon.UI.Screens.EndScreen;
import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.UI.Screens.LeaderboardScreen;
import com.vikingz.campustycoon.UI.Screens.SettingsScreen;
import com.vikingz.campustycoon.UI.Screens.StartScreen;

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
