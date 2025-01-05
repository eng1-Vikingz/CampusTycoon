package com.vikingz.campustycoon.headless.Game.GameLogic;


import com.vikingz.campustycoon.Game.Buildings.Accommodation;
import com.vikingz.campustycoon.Game.Buildings.Building;
import com.vikingz.campustycoon.Game.GameLogic.SatisfactionMeter;
import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.UI.Components.Component;
import com.vikingz.campustycoon.Util.Types.Coordinate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;





public class SatisfactionMeterTest {

    @BeforeEach
    public void setUp() {
        Map.buildings = new ArrayList<>();
        SatisfactionMeter.satisfactionText = Mockito.mock(Component.class);
    }

    @Test
    public void testGetSatisfactionScore() {
        assertEquals(0, SatisfactionMeter.getSatisfactionScore());
    }

    @Test
    public void testModifySatisfactionScore() {
        SatisfactionMeter.modifySatisfactionScore(5);
        assertEquals(5, SatisfactionMeter.getSatisfactionScore());
    }

    @Test
    public void testUpdateDisplay() {
        SatisfactionMeter.modifySatisfactionScore(5);
        SatisfactionMeter.updateDisplay();
    }

    @Test 
    public void testUpdateSatisfactionScore(){
        assertEquals(0, SatisfactionMeter.getSatisfactionScore());
        SatisfactionMeter.updateSatisfactionScore();
        assertEquals(0, SatisfactionMeter.getSatisfactionScore());
        Map.buildings.add(new Accommodation(new Coordinate(0,0)));
        Map.buildings.add(new Accommodation(new Coordinate(10,10)));
        SatisfactionMeter.updateSatisfactionScore();
        assertEquals(0, SatisfactionMeter.getSatisfactionScore());

    }
}