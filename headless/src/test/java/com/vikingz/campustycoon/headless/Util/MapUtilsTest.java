package com.vikingz.campustycoon.headless.Util;

import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.Game.Buildings.Accommodation;
import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.Util.MapUtils;
import com.vikingz.campustycoon.Util.Types.Coordinate;

public class MapUtilsTest {
    

    @Test
    void testConstructor(){
        
        MapUtils mapUtils = new MapUtils(null);
    }

    @Test
    void testGetBuilding(){

        MapUtils.getBuilding("ACCOMMODATION");
        MapUtils.getBuilding("STUDY");
        MapUtils.getBuilding("STUDY2");
        MapUtils.getBuilding("CAFETERIA");
        MapUtils.getBuilding("RELAXATION");
        MapUtils.getBuilding("RELAXATION2");
        MapUtils.getBuilding("ROAD");
    }

    @Test
    void testBuildingPlaceable(){

        MapUtils mu = new MapUtils(null);
        assertFalse(mu.buildingPlaceable(new Accommodation()));

    }

    @Test
    void testTileHasBuilding(){
        
        MapUtils mu = new MapUtils(null);
        assertFalse(mu.tileHasBuilding(new Coordinate()));
    }




}
