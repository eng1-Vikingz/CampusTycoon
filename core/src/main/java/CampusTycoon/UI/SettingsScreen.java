package CampusTycoon.UI;


import java.util.ArrayList;
import java.util.List;

import CampusTycoon.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * This class is used for drawing game stats to the screen.
 *
 * This class contains all the labels that are on the
 * top right of the screen that display the users balance,
 * satisfaction etc.
 */
public class SettingsScreen implements Screen {

    final int PADDING = 3;


    //Used to render UI
    private final SpriteBatch batch;
    private final BitmapFont font;
    private final Stage stage;
    private final Skin skin;
    private final Label resolutionLabel;


    //Used to resize UI renderer to new screen size
    float width;
    float height;


    // Buttons

    TextButton backBtn;

    //Stores all labels
    List<Label> labels;

    // Container for drawing labels to the screen
    Table table;


    public SettingsScreen() {

        super();

        this.skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));


        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());

        font = new BitmapFont();
        font.getData().setScale(1.5f);
        labels = new ArrayList<>();

        // Resolution label
        this.resolutionLabel = new Label(Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight() + " fps " + Gdx.graphics.getFramesPerSecond(),skin);


        // Back button
        backBtn = new TextButton("Back", skin);

        backBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                ScreenUtils.OpenStartScreen();
                ScreenUtils.resetInputProcessor();
            }
        });

        // Create layout table
        this.table = new Table();
        table.setFillParent(true);
        table.top();
        table.center();
        createTitleLbl();

        TextButton fullscreenButton = new TextButton("Fullscreen",skin);
        fullscreenButton.addListener(e -> {
            if (fullscreenButton.isPressed()){
                Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
            }
            return true;
        });

        TextButton windowButton = new TextButton("Window Mode", skin);
        windowButton.addListener(e -> {
            if (windowButton.isPressed()){
                Gdx.graphics.setWindowedMode(1280,720);
            }
            return true;
        });


        // Add back button to table

        table.row().padTop(20);
        table.row();
        table.add(resolutionLabel);
        table.row().padTop(50);
        table.add(windowButton).padBottom(55);
        table.row().padBottom(50);
        table.add(fullscreenButton);
        table.row();
        table.add(backBtn).pad(PADDING).align(Align.center);


        stage.addActor(table);

    }

    private void createTitleLbl(){
        Label title = new Label("Settings", skin);
        title.setColor(Color.WHITE);
        title.setFontScale(3f);

        table.add(title).pad(PADDING).align(Align.center);
        table.row();
        table.row();
        labels.add(title);

    }


    private void addLabel(String text){
        Label lbl = new Label(text, this.skin);
        lbl.setColor(Color.WHITE);
        lbl.setFontScale(1.5f);

        table.add(lbl).pad(PADDING).align(Align.center);
        table.row();

        labels.add(lbl);

    }




    /**
     * Draws the labels to the screen
     * @param delta Time since last frame
     */
    @Override
    public void render(float delta) {
        //clears screen
        com.badlogic.gdx.utils.ScreenUtils.clear(Color.BLACK);
        Drawer.drawAll();
        resolutionLabel.setText(CurrentWindowSize());


        batch.begin();

        stage.act(delta);
        stage.draw();
        batch.end();
    }

    /**
     * Sets current width and height to the new values when the window is resized
     * @param width New width
     * @param height New height
     */
    @Override
    public void resize(int width, int height){
        this.width = width;
        this.height = height;
        Window.updateResolution(width, height);
        Drawer.updateAll();
        stage.getViewport().update(width, height, true);

    }

    public static String CurrentWindowSize(){
        Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode();
        if (Gdx.graphics.isFullscreen()) return displayMode.toString();
        return Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight() + ", bpp " + displayMode.bitsPerPixel + " hz: "+ Gdx.graphics.getFramesPerSecond();
    }



    /**
     * disposes stats being drawn for garbage collection
     */
    public void dispose(){
        stage.dispose();
        batch.dispose();
        font.dispose();
    }


    @Override
    public void show() {
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {
    }


    @Override
    public void hide() {
        Drawer.clear();
        InputHandler.clear();
    }

    public void takeInput(){
        Gdx.input.setInputProcessor(stage);
    }

}

