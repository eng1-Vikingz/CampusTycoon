package com.vikingz.campustycoon.UI.Screens;

import com.vikingz.campustycoon.UI.Components.BankruptMenu;
import com.vikingz.campustycoon.UI.Components.PauseMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

import com.vikingz.campustycoon.Game.GameLogic.Event;
import com.vikingz.campustycoon.Game.GameLogic.MoneyHandler;
import com.vikingz.campustycoon.Game.GameLogic.Timer;
import com.vikingz.campustycoon.UI.Window;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.GameUtils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is used to create the gameplay screen.
 */
public class GameplayScreen implements Screen{
    private Timer timer;
    private boolean stateChanged;
    private float elapsedTime;
    private ThreadLocalRandom rand;
    private float eventCounter;
    private Skin skin;
    private PauseMenu pauseMenu;
    private boolean paused;
    private BankruptMenu bankruptMenu;
    private boolean bankrupt;


    /**
     * Shows the gameplay screen.
     */
    @Override
    public void show() {
        if (!com.vikingz.campustycoon.Util.ScreenUtils.GameActive) {
            timer = new Timer(5, skin); // Sets a countdown for 300 seconds (5 minutes)
            timer.start();
            GameUtils.startGame();
            GameUtils.createGameplayUI();
            stateChanged = false;  // Reset stateChanged when the screen is shown
            elapsedTime = 0;
            rand = ThreadLocalRandom.current();
            eventCounter = 0f;
            this.skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));
            pauseMenu = new PauseMenu(skin);
            bankruptMenu = new BankruptMenu(skin);
            paused = false;
            bankrupt = false;
            com.vikingz.campustycoon.Util.ScreenUtils.GameActive = true;
        }
    }

    /**
     * Render the gameplay screen.
     */
    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ScreenUtils.clear(Color.BLACK);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            pause();
        }

        if (!paused) {
            timer.update(delta); // Update the timer every frame
            MoneyHandler.update(delta); // Update the balance of the player
            // Check if the timer has ended and stateChanged is false
            if (timer.hasEnded() && !stateChanged) {
                stateChanged = true; // Set the flag to true to prevent re-execution
            }

            //times when next event is
            eventCounter += rand.nextInt(0, 1000) * delta;
            if (eventCounter >= 12000 && GameUtils.currentEvent == null) {
                eventCounter = 0;
                //Pop event
                GameUtils.currentEvent = new Event();
                System.out.println("Event opened");
            }


            elapsedTime += delta; // delta is the time elapsed since the last frame
            if (elapsedTime >= 1) { // Increment counter every second

                System.out.println("second");

            }

            elapsedTime = 0; // Reset elapsed time

        }
        Drawer.drawAll();
    }

    /**
     * Set the paused state of the game.
     * @param paused
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * Resize the gameplay screen.
     */
    @Override
    public void resize(int width, int height) {
        Window.updateResolution(width, height);
        Drawer.updateAll();
        Drawer.stage.getViewport().update(width, height, true);

    }

    /**
     * Pause the game.
     * -> Opens the pause menu
     */
    @Override
    public void pause() {
        if (!bankrupt) {
            if (!paused) {
                Drawer.stage.addActor(pauseMenu);
                pauseMenu.toFront();
                pauseMenu.setPosition((Drawer.stage.getWidth() - pauseMenu.getWidth()) / 2, ((Drawer.stage.getHeight() - pauseMenu.getHeight()) / 2)-50);
                Gdx.input.setInputProcessor(Drawer.stage);
                paused = true;
            } else {
                com.vikingz.campustycoon.Util.ScreenUtils.resetInputProcessor();
                pauseMenu.remove();
                paused = false;
            }
        }
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }

    /**
     * Display the bankrupt warning.
     */
    public void displayBankruptWarning() {
        this.bankrupt = true;
        this.paused = true;
        Drawer.stage.addActor(bankruptMenu);
        bankruptMenu.setPosition((Drawer.stage.getWidth() - pauseMenu.getWidth()) / 2, ((Drawer.stage.getHeight() - pauseMenu.getHeight()) / 2)-50);
        Gdx.input.setInputProcessor(Drawer.stage);
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }
}
