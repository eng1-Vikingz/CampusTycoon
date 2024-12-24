package CampusTycoon.UI.Screens;


import java.util.ArrayList;
import java.util.List;

import CampusTycoon.UI.Window;
import CampusTycoon.Util.Drawer;
import CampusTycoon.Util.GameMusic;
import CampusTycoon.Util.InputHandler;
import CampusTycoon.Util.ScreenUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
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
    private final Slider MusicVolumeSlider;
    private final Label MusicVolumeLabel;
    private String musicVolume;
    private String soundVolume;


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
                goBack();
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

        // Create Music volume slider
        MusicVolumeSlider = new Slider(0, 1, 0.1f, false, skin); // Min: 0, Max: 100, Step: 1
        MusicVolumeSlider.setValue(GameMusic.getVolume());
        MusicVolumeLabel = new Label(musicVolume, skin);
        this.musicVolume = "Music Volume: " + MusicVolumeSlider.getValue();


        // Add back button to table
        table.row().padTop(20);
        table.row();
        table.add(resolutionLabel);
        table.row().padTop(50);
        table.add(fullscreenButton).padBottom(10);;
        table.row().padBottom(25);
        table.add(windowButton);
        table.row();
        table.add(MusicVolumeLabel);
        table.row();
        table.add(MusicVolumeSlider);
        table.row().padBottom(50);
        table.add(backBtn).pad(PADDING).align(Align.center);

        stage.addActor(table);

    }

    private void goBack() {
        if (ScreenUtils.GameActive) {
            ScreenUtils.resetInputProcessor();
            ScreenUtils.openGameplayScreen();
        }
        else {
            ScreenUtils.OpenStartScreen();
            ScreenUtils.resetInputProcessor();
        }
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
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        com.badlogic.gdx.utils.ScreenUtils.clear(Color.BLACK);




        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            goBack();
        }

        //Update labels strings
        //soundVolume = "Sound Volume: " + Math.round(SoundVolumeSlider.getValue() * 10);
        musicVolume = "Music Volume: " + Math.round(MusicVolumeSlider.getValue() * 10);

        //Update Values
        //GameSounds.setVolume(SoundVolumeSlider.getValue());
        GameMusic.setVolume(MusicVolumeSlider.getValue());

        //Apply update
        //SoundVolumeLabel.setText(soundVolume);
        MusicVolumeLabel.setText(musicVolume);
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

    }

    public void takeInput(){
        Gdx.input.setInputProcessor(stage);
    }

}

