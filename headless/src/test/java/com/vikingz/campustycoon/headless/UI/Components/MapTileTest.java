package com.vikingz.campustycoon.headless.UI.Components;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import com.vikingz.campustycoon.UI.Components.MapTile;
import com.vikingz.campustycoon.UI.Components.SpriteSheet;


public class MapTileTest {


    @Test
    void testConstructor(){
        MapTile tile = new MapTile();
        assertEquals(0, tile.getBaseX());
        assertEquals(0, tile.getBaseY());
        assertEquals(0, tile.getBaseWidth());
        assertEquals(0, tile.getBaseHeight());
    }


    @Test
    void testConstructorWithParameters() {
        int baseX = 10;
        int baseY = 20;
        int baseWidth = 30;
        int baseHeight = 40;

        MapTile tile = new MapTile(new SpriteSheet(null, baseY, baseHeight, baseWidth, baseHeight), baseHeight, baseX, baseY);
        assertEquals(baseX, tile.getBaseX());
        assertEquals(baseY, tile.getBaseY());
        assertEquals(baseWidth, tile.getBaseWidth());
        assertEquals(baseHeight, tile.getBaseHeight());
    }

    
    @Test
    void testApplyZoomOffset(){

        MapTile tile = new MapTile();
        tile.applyZoomOffset();
        assertEquals(0, tile.getBaseX());
    }

}