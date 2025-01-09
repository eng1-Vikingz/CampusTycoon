package com.vikingz.campustycoon.headless.UI.Screens;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.headless.mock.graphics.MockGraphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.vikingz.campustycoon.UI.Screens.EndScreen;
import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.UI.Screens.LeaderboardScreen;
import com.vikingz.campustycoon.UI.Screens.SettingsScreen;
import com.vikingz.campustycoon.UI.Screens.StartScreen;
import com.vikingz.campustycoon.headless.HeadlessLauncher;

public class ScreensTest {

    SpriteBatch batch;

    Screen end, game, leaderboard, settings, start;

    @BeforeEach
    void setUpHeadless(){

        // This runs the game before each test in headless mode !


        new HeadlessLauncher();

        HeadlessLauncher.main(new String[0]);

        GL20 gl20 = Mockito.mock(GL20.class);
        Gdx.gl = gl20;
        Gdx.gl20 = gl20;

        batch = mock(SpriteBatch.class);
        when(batch.getProjectionMatrix()).thenReturn(new Matrix4());


    }
    
    
    @Test
    void testCreateScreen(){
        
        end = new EndScreen();
        game = new GameplayScreen();
        
        
        leaderboard = new LeaderboardScreen(true);
        settings = new SettingsScreen();
        start = new StartScreen();
    }






}
