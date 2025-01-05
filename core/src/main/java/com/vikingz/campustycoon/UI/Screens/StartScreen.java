package com.vikingz.campustycoon.UI.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import com.vikingz.campustycoon.UI.Window;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.GameUtils;
import com.vikingz.campustycoon.Util.InputHandler;

/**
 * This class is used to create the start screen.
 */
public class StartScreen implements Screen{

    /**
     * Creates and new StartScreen
     */
    public StartScreen() {
    }

    /**
     * Show the start screen.
     */
    @Override
    public void show() {
        GameUtils.createStartMenuUI();
    }

    /**
     * Render the start screen.
     */
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        Drawer.drawAll();
    }
    
    /**
     * Resize the start screen.
     */
    @Override
    public void resize(int width, int height) {
        Window.updateResolution(width, height);
        Drawer.updateAll();
    }

    @Override
    public void pause() {
        // Menu screen can't be paused, so nothing will be done
    }

    @Override
    public void resume() {
        // Menu screen can't be resumed, so nothing will be done
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
        Drawer.clear();
        InputHandler.clear();
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
