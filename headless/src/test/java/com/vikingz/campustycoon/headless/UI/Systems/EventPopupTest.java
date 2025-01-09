package com.vikingz.campustycoon.headless.UI.Systems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.UI.Components.Button;
import com.vikingz.campustycoon.UI.Systems.EventPopup;

public class EventPopupTest {
    
    @Test
    void testElements(){

        Button btn = new Button(0, 0, 0, 0);
        EventPopup.addElement(btn);
        assertEquals(btn, EventPopup.getLastElement());

    }


}
