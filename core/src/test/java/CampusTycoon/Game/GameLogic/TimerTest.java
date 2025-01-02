package CampusTycoon.Game.GameLogic;

import org.junit.jupiter.api.Test;
import CampusTycoon.Game.GameLogic.Timer;



public class TimerTest {
    
    Timer timer;

    @Test
    public void testCreateTimer(){
        timer = new Timer(100);
    }

}
