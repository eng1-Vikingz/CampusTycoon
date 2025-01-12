package com.vikingz.campustycoon.headless.Game.GameLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.vikingz.campustycoon.UI.Screens.LeaderboardScreen;
import com.vikingz.campustycoon.headless.HeadlessLauncher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.Game.GameLogic.Timer;
import org.mockito.Mockito;


public class TimerTest {

    Timer timer;


    @BeforeEach
    public void testCreateTimer(){

        // This runs the game before each test in headless mode !

        new HeadlessLauncher();
        HeadlessLauncher.main(new String[0]);
        GL20 gl20 = Mockito.mock(GL20.class);
        Gdx.gl = gl20;
        Gdx.graphics = Mockito.mock(com.badlogic.gdx.Graphics.class);
        assertTrue(Gdx.files.internal("glassy-ui/skin/glassy-ui.json").exists());
        Skin skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));
        timer = new Timer(100, skin);
    }

    @Test
    public void testStartTimer(){
        timer.start();
        assertTrue(timer.isRunning());
    }

    @Test
    public void testStopTimer(){
        timer.pause();
    }

    @Test
    public void testResetTimer(){
        timer.reset(100);
        assertEquals(100, Timer.getTimeRemaining());
    }

    @Test
    public void testUpdateTimer(){
        timer.start();
        timer.update(5);
        assertEquals(95, Timer.getTimeRemaining());
    }


    @Test
    public void testfloatToMinSec(){

        assertEquals("Time: 1:40", Timer.floatToMinSec(100));
        assertEquals("Time: 10:00", Timer.floatToMinSec(600));
        assertEquals("Time: 0:40", Timer.floatToMinSec(40));
        assertEquals("Time: 0:05", Timer.floatToMinSec(5));
        assertEquals("Time: 1:05", Timer.floatToMinSec(65));
        assertEquals("Time: 5:00", Timer.floatToMinSec(300));

        assertEquals(null, Timer.floatToMinSec(100000000));


    }



}
