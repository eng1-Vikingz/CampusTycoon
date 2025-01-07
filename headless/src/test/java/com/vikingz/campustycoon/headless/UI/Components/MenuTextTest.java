package com.vikingz.campustycoon.headless.UI.Components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.UI.Components.MenuText;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTextTest {
    

    @Test
    void createMenuText() {

        float x = 10;
        float y = 20;
        float widthScale = 30;
        float heightScale = 40;


        MenuText menuText = new MenuText("Test", x, y, widthScale, heightScale);
        assertNotNull(menuText);

        assertEquals(10, menuText.x);
        assertEquals(660, menuText.y);
        assertEquals(widthScale, menuText.width);
        assertEquals(heightScale, menuText.height);

    }

    @Test
    void setClickAction() {
        MenuText menuText = new MenuText("Test", 10, 20, 30, 40);

        assertThrows(UnsupportedOperationException.class, () -> menuText.setClickAction("Test"));


    }
    

}
