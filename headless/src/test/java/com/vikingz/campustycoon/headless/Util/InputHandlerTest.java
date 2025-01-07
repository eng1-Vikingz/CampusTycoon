package com.vikingz.campustycoon.headless.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Input;
import com.vikingz.campustycoon.UI.Components.Button;
import com.vikingz.campustycoon.UI.Components.Component;
import com.vikingz.campustycoon.Util.InputHandler;
import com.vikingz.campustycoon.headless.HeadlessLauncher;

public class InputHandlerTest {
    
    InputHandler inputHandler;

    Button btn0, btn1;

    @BeforeEach
    void setUp() {
        
        HeadlessLauncher.main(new String[0]);

        btn0 = new Button(0, 0, 100, 100);
        btn1 = new Button(1, 1, 100, 100);

        inputHandler = new InputHandler();
        assertNotNull(inputHandler);
        InputHandler.clear();

    
    }

    @Test
    void testAdd(){

        InputHandler.add(btn0);
        InputHandler.add(btn1);

        assertEquals(btn0, InputHandler.clickables.get(0));
        assertEquals(btn1, InputHandler.clickables.get(1));

    }

    @Test
    void testRemove(){
        
        InputHandler.add(btn0);

        assertFalse(InputHandler.clickables.isEmpty());

        InputHandler.remove(btn0);
        assertTrue(InputHandler.clickables.isEmpty());

    }

    @Test
    void testClear(){
        
        InputHandler.add(btn0);
        InputHandler.add(btn1);

        assertFalse(InputHandler.clickables.isEmpty());

        InputHandler.clear();
        assertTrue(InputHandler.clickables.isEmpty());

    }

    @Test
    void testAddAll(){
        ArrayList<Component> buttons = new ArrayList<Component>();
        buttons.add(btn0);
        buttons.add(btn1);

        InputHandler.clear();
        InputHandler.add(buttons);

        assertEquals(2, InputHandler.clickables.size());
    }




}
