package CampusTycoon.UI.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.Game.GameLogic.Event;
import CampusTycoon.Game.GameLogic.MoneyHandler;
import CampusTycoon.Game.GameLogic.Timer;
import CampusTycoon.UI.Window;
import CampusTycoon.Util.Drawer;
import CampusTycoon.Util.GameUtils;

import java.util.concurrent.ThreadLocalRandom;

public class GameplayScreen implements Screen{
    private Timer timer;
    private boolean stateChanged;
    private float elapsedTime;
    private ThreadLocalRandom rand;
    private float eventCounter;


    @Override
    public void show() {
        timer = new Timer(300); // Sets a countdown for 300 seconds (5 minutes)
        timer.start();
        GameUtils.startGame();
        GameUtils.createGameplayUI();
        stateChanged = false;  // Reset stateChanged when the screen is shown
        elapsedTime = 0;
        rand = ThreadLocalRandom.current();
        eventCounter = 0f;
    }

    @Override
    public void render(float delta) {
        timer.update(delta); // Update the timer every frame
        MoneyHandler.update(delta); // Update the balance of the player


        // Check if the timer has ended and stateChanged is false
        if (timer.hasEnded() && !stateChanged) {
            stateChanged = true; // Set the flag to true to prevent re-execution
        }

        ScreenUtils.clear(Color.BLACK);
        Drawer.drawAll();


        //times when next event is
        eventCounter += rand.nextInt(0,1000) * delta;
        if (eventCounter >= 12000 && GameUtils.currentEvent == null){
            eventCounter =0;
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
        }

        @Override
        public void dispose() {
            // Destroy screen's assets here.
        }
    }
