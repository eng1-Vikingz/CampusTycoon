package com.vikingz.campustycoon.UI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;
import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Game.GameLogic.MoneyHandler;
import com.vikingz.campustycoon.Game.GameLogic.SatisfactionMeter;
import com.vikingz.campustycoon.UI.Window;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.GameUtils;
import com.vikingz.campustycoon.Util.InputHandler;

/**
 * This class is used to create the end screen.
 */
public class EndScreen implements Screen{

    /**
     * Constructor for the EndScreen class.
     */
    public EndScreen() {

    }

    /**
     * Show the end screen.
     */
    @Override
    public void show() {
        Drawer.clear();
        GameUtils.createEndScreenUI();
        MoneyHandler.resetBank();
        BuildingCounter.reset();
        SatisfactionMeter.updateSatisfactionScore();
    }

    /**
     * Render the end screen.
     */
    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ScreenUtils.clear(Color.BLACK);

        Drawer.drawAll();



    }

    /**
     * Resize the end screen.
     */
    @Override
    public void resize(int width, int height) {
        Window.updateResolution(width, height);
        Drawer.updateAll();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
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
