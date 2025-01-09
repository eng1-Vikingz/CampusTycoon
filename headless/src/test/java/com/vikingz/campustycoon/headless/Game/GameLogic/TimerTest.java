package com.vikingz.campustycoon.headless.Game.GameLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.Game.GameLogic.Timer;



public class TimerTest {
    
    Timer timer;

    @BeforeEach
    public void testCreateTimer(){
        timer = new Timer(100);
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

        assertEquals("Time: 01:40", Timer.floatToMinSec(100));
        assertEquals("Time: 10:00", Timer.floatToMinSec(600));
        assertEquals("Time: 00:40", Timer.floatToMinSec(40));
        assertEquals("Time: 00:05", Timer.floatToMinSec(5));
        assertEquals("Time: 01:05", Timer.floatToMinSec(65));
        assertEquals("Time: 05:00", Timer.floatToMinSec(300));

        assertEquals(null, Timer.floatToMinSec(100000000));


    }



}
