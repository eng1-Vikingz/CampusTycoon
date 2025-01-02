package CampusTycoon.UI.Screens;

import org.junit.jupiter.api.BeforeAll;

import com.badlogic.gdx.Screen;

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
