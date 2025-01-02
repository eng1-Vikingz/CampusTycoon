package CampusTycoon.GameLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CampusTycoon.Game.GameLogic.Timer;


public class TimerTest {

    private Timer timer;

    @BeforeAll
    public void setUp() {
        timer = new Timer(60); // Initialize with 60 seconds
    }

    @Test
    public void testInitialTime() {
        assertEquals(60, Timer.getTimeRemaining(), 0.01);
    }

    @Test
    public void testStart() {
        timer.start();
        assertFalse(timer.hasEnded());
    }

    @Test
    public void testPause() {
        timer.start();
        timer.pause();
        assertFalse(timer.hasEnded());
    }

    @Test
    public void testReset() {
        timer.reset(120);
        assertEquals(120, Timer.getTimeRemaining(), 0.01);
        assertFalse(timer.hasEnded());
    }

    @Test
    public void testUpdate() {
        timer.start();
        timer.update(30);
        assertEquals(30, Timer.getTimeRemaining(), 0.01);
    }

    @Test
    public void testOnTimeUp() {
        timer.start();
        timer.update(60);
        assertTrue(timer.hasEnded());
        assertEquals(0, Timer.getTimeRemaining(), 0.01);
    }
}