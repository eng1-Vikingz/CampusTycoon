package com.vikingz.headless.Game.Tiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.vikingz.Game.Tiles.Grass;
import com.vikingz.Game.Tiles.Lake;
import com.vikingz.Game.Tiles.Mountain;
import com.vikingz.Game.Tiles.Tile;



public class TilesTest {
    

   static Tile grass, lake, mountain;

    @BeforeAll
    public static void setUp() {
        grass = new Grass();
        lake = new Lake();
        mountain = new Mountain();

    }

    @Test
    public void testGetTileIDs() {

        assertEquals(0, grass.getTileID());
        assertEquals(1, lake.getTileID());
        assertEquals(2, mountain.getTileID());


    }



}
