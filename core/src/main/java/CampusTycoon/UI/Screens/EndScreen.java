package CampusTycoon.UI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;

import CampusTycoon.UI.Window;
import CampusTycoon.Util.Drawer;
import CampusTycoon.Util.GameUtils;
import CampusTycoon.Util.InputHandler;


public class EndScreen implements Screen{

    /** First screen of the application. Displayed after the application is created. */
        public EndScreen() {
        }

        @Override
        public void show() {
            Drawer.clear();
			GameUtils.createEndScreenUI();
        }

        @Override
        public void render(float delta) {
            // Clear screen
            Gdx.gl.glClearColor(0.1f, 0.1f, 0.4f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            ScreenUtils.clear(Color.BLACK);

            Drawer.drawAll();



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
            // This method is called when another screen replaces this one.
			Drawer.clear();
			InputHandler.clear();
        }

        @Override
        public void dispose() {
            // Destroy screen's assets here.
        }
    }
