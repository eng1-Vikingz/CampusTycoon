package com.vikingz.campustycoon.UI.Screens;


import java.util.ArrayList;
import java.util.List;

import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.InputHandler;
import com.vikingz.campustycoon.Util.LeaderboardFileHandler;
import com.vikingz.campustycoon.Util.ScreenUtils;
import com.vikingz.campustycoon.Util.Types.Tuple;

import com.badlogic.gdx.Gdx;
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

/**
 * This class is used for drawing game stats to the screen.
 *
 * This class contains all the labels that are on the
 * top right of the screen that display the users balance,
 * satisfaction etc.
 */
public class LeaderboardScreen implements Screen {

    final int PADDING = 3;


    //Used to render UI
    private final SpriteBatch batch;
    private final BitmapFont font;
    private final Stage stage;
    private final Skin skin;

    //Used to resize UI renderer to new screen size
    float width;
    float height;


    // Buttons

    TextButton backBtn;

    //Stores all labels
    List<Label> labels;

    // Container for drawing labels to the screen
    Table table;


    /**
     * Constructor for the LeaderboardScreen class.
     */
    public LeaderboardScreen() {
        this(new SpriteBatch());
    }

    /**
     * Constructor for the LeaderboardScreen class.
     * I needed to add a constructor that takes a SpriteBatch as an argument since
     * when i was unit testing this class, i had to pass in a 'Mockito' sprite batch
     * to run the tests in a headless environment.
     * @param batch
     */
    public LeaderboardScreen(SpriteBatch batch) {

        super();

        this.skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));

        this.batch = batch;
        SpriteBatch.createDefaultShader();
        
        stage = new Stage();

        font = new BitmapFont();
        font.getData().setScale(1.5f);
        labels = new ArrayList<>();

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

        // addLabel("TEST1");
        // addLabel("TEST2");
        // addLabel("TEST3");


        for(Tuple<String, Integer> entry : LeaderboardFileHandler.getLeaderboardTopFive()){
            addLabel(entry.x + " :: " + entry.y);
        }


        // Add back button to table
        table.row();
        table.row();
        table.row();
        table.add(backBtn).pad(PADDING).align(Align.center);

        stage.addActor(table);

    }

    /**
     * Creates the title label for the leaderboard screen
     */
    private void createTitleLbl(){
        Label title = new Label("LEADERBOARD", skin);
        title.setColor(Color.WHITE);
        title.setFontScale(3f);

        table.add(title).pad(PADDING).align(Align.center);
        table.row();
        table.row();

        labels.add(title);

    }


    /**
     * Adds a label to the screen
     * Used to add a new entry on the leaderboard
     * @param text Text to be displayed on the label
     */
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


        System.out.println("Rendering leaderboard");
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
    public void resize(float width, float height){
        this.width = width;
        this.height = height;
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
    public void resize(int width, int height) {
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

