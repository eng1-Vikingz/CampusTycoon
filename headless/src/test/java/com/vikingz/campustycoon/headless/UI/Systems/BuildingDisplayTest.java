package com.vikingz.campustycoon.headless.UI.Systems;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.UI.Systems.BuildingDisplay;

public class BuildingDisplayTest {
    

    @Test
    void testCreateBuildingDisplay(){

        BuildingDisplay bd = new BuildingDisplay(new ArrayList<>());
        bd.drawBuildings();
        assertNotNull(bd);
    }

}
