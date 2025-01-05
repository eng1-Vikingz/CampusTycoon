package com.vikingz.campustycoon.headless.UI.Components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.vikingz.campustycoon.UI.Components.PopupMenu;
import com.vikingz.campustycoon.headless.HeadlessLauncher;

public class PopupMenuTest {
    
    PopupMenu popupMenu;
    Skin skin;

    @BeforeEach
    void setUp(){

        // This runs the game before each test in headless mode !

        new HeadlessLauncher();
        HeadlessLauncher.main(new String[0]);

        GL20 gl20 = Mockito.mock(GL20.class);
        Gdx.gl = gl20;
        Gdx.graphics = Mockito.mock(com.badlogic.gdx.Graphics.class);

        assertTrue(Gdx.files.internal("glassy-ui/skin/glassy-ui.json").exists());
        skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));
    }

    @Test
    void createPopupMenu() {

        popupMenu = new PopupMenu(skin, "TEST");
        assertNotNull(popupMenu);

        assertEquals("TEST", popupMenu.getMessage());
        popupMenu.setMessage("TEST2");
        assertEquals("TEST2", popupMenu.getMessage());
    }

    @Test
    void testSetupButtons(){

        popupMenu = new PopupMenu(skin, "TEST");

        Runnable leftRun = new Runnable() {
            @Override
            public void run() {
                System.out.println("Left Button Pressed");
            }
        };

        Runnable rightRun = new Runnable() {
            @Override
            public void run() {
                System.out.println("Right Button Pressed");
            }
        };

        popupMenu.setupButtons(leftRun, "Left", rightRun, "Right");

    }

    
    @Test
    void testSetupRightBtn(){

        popupMenu = new PopupMenu(skin, "TEST");


        Runnable rightRun = new Runnable() {
            @Override
            public void run() {
                System.out.println("Right Button Pressed");
            }
        };


        popupMenu.setupRightBtn(rightRun, "Right");

    }



}
