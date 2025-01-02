package com.vikingz.headless.Game.GameLogic;

import org.junit.jupiter.api.Test;
import com.vikingz.Game.GameLogic.Timer;



public class TimerTest {
    
    Timer timer;

    @Test
    public void testCreateTimer(){
        timer = new Timer(100);
    }

}
