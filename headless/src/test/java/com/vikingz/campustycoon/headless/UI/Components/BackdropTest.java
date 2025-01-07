package com.vikingz.campustycoon.headless.UI.Components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.UI.Components.Backdrop;

public class BackdropTest {
    
    @Test
    void testCreateBackdropAndGettersAndSetters(){
        
        int x = 1;
        int y = 2;
        int width = 100;
        int height = 200;

        int expectedX = 1;
        int expectedY = 518;
        int expectedWidth = 100;
        int expectedHeight = 200;

        Backdrop bd1 = new Backdrop(x, y, width, height);
        Backdrop bd2 = new Backdrop("default", x, y, width, height);
        Backdrop bd3 = new Backdrop(new ArrayList<>(), x, y, width, height);

        //assertEquals(128, bd1.getX());
        assertEquals(expectedY, bd1.getY());
        assertEquals(expectedWidth, bd1.getWidth());
        assertEquals(expectedHeight, bd1.getHeight());

        assertEquals(expectedX, bd2.getX());
        assertEquals(expectedY, bd2.getY());
        assertEquals(expectedWidth, bd2.getWidth());
        assertEquals(expectedHeight, bd2.getHeight());

        assertEquals(expectedX, bd3.getX());
        assertEquals(expectedY, bd3.getY());
        assertEquals(expectedWidth, bd3.getWidth());
        assertEquals(expectedHeight, bd3.getHeight());

        bd3.setX(50);
        bd3.setY(60);
        bd3.setWidth(500);
        bd3.setHeight(600);
        
        assertEquals(50, bd3.getX());
        assertEquals(60, bd3.getY());
        assertEquals(500, bd3.getWidth());
        assertEquals(600, bd3.getHeight());


    }

    @Test
    void testThrows(){

        Backdrop bd = new Backdrop(0, 0, 0, 0);
        assertThrows(UnsupportedOperationException.class, 
        () -> {bd.setClickAction("");
    });

    }



}
