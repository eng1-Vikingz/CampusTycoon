package com.vikingz.campustycoon.Screens;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.vikingz.campustycoon.UI.Screens.LeaderboardScreen;

public class ScreensTest {
    
    @Test
    void testCreateScreen(){
        // test code here

        GL20 gl20 = Mockito.mock(GL20.class);
        Gdx.gl = gl20;
        Gdx.gl20 = gl20;

        //assertTrue(Gdx.files.internal("glassy-ui/skin/glassy-ui.json").exists());

        //LeaderboardScreen leaderboard = new LeaderboardScreen();
    }

}
