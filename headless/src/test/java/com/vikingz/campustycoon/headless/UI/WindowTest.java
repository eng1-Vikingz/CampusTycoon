package com.vikingz.campustycoon.headless.UI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.UI.Window;

public class WindowTest {
    

    @Test
    void testCreateNewWindow(){
        Window window = new Window();
        assertNotNull(window);
    }


    @Test
    void testUpdateRes(){
        Window window = new Window();
        assertNotNull(window);

        Window.updateResolution(10, 20);
        assertEquals(10,Window.width);
        assertEquals(20, Window.height);


    }



}
