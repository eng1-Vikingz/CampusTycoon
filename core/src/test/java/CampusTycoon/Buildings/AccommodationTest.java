package CampusTycoon.Buildings;

import static org.junit.jupiter.api.Assertions.*;

import CampusTycoon.GameLogic.BuildingCounter;

import org.junit.jupiter.api.Test;

class AccommodationTest {




    @Test
    void test_incrementBuildingCounter() {
        Accommodation accommodation = new Accommodation();
        accommodation.incrementBuildingCounter();

        int count = BuildingCounter.getBuildingCount(Accommodation.buildingName);
        assertEquals(1, count);

        accommodation.incrementBuildingCounter();
        count = BuildingCounter.getBuildingCount(Accommodation.buildingName);
        assertEquals(2, count);
    }

}