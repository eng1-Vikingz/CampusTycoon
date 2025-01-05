package com.vikingz.campustycoon.headless.Game.GameLogic;

import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildingCounterTest {

    @BeforeEach
    public void setUp() {
        BuildingCounter.reset();
    }

    @Test
    public void testReset() {
        BuildingCounter.increaseBuildingCounter("Accommodation", 5);
        BuildingCounter.reset();
        assertEquals(0, BuildingCounter.getTotalBuildingCount());
        assertEquals(0, BuildingCounter.getBuildingCount("Accommodation"));
    }

    @Test
    public void testIncreaseBuildingCounter() {
        BuildingCounter.increaseBuildingCounter("Accommodation", 3);
        assertEquals(3, BuildingCounter.getBuildingCount("Accommodation"));
        assertEquals(3, BuildingCounter.getTotalBuildingCount());
    }

    @Test
    public void testDecreaseBuildingCounter() {
        BuildingCounter.increaseBuildingCounter("Accommodation", 5);
        BuildingCounter.decreaseBuildingCounter("Accommodation", 2);
        assertEquals(3, BuildingCounter.getBuildingCount("Accommodation"));
        assertEquals(3, BuildingCounter.getTotalBuildingCount());
    }

    @Test
    public void testGetBuildingCountByBuilding() {
        BuildingCounter.increaseBuildingCounter("Study", 4);
        assertEquals(4, BuildingCounter.getBuildingCountByBuilding("Study"));
    }

    @Test
    public void testTotalBuildingCount() {
        BuildingCounter.increaseBuildingCounter("Cafeteria", 2);
        BuildingCounter.increaseBuildingCounter("Study", 1);
        BuildingCounter.increaseBuildingCounter("Accomodation", 3);
        
        assertEquals(6, BuildingCounter.getTotalBuildingCount());
    }

    @Test
    public void testUpdateDisplay() {
        BuildingCounter.increaseBuildingCounter("Cafeteria", 2);
        BuildingCounter.updateDisplay();
    }
}

