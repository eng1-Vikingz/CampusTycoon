package com.vikingz.campustycoon.UI.Screens;

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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.InputHandler;
import com.vikingz.campustycoon.Util.ScreenUtils;

import java.util.ArrayList;

import static javax.swing.text.html.CSS.Attribute.PADDING;

public class InstructionScreen implements Screen {

    private final Skin skin;
    private TextButton backBtn;
    private final Table table;
    private SpriteBatch batch;
    private final Stage stage;
    private final BitmapFont font;
    private final ArrayList<Label> labels;


    /**
     * Constructor for the InstructionScreen class.
     * I needed to add a constructor that takes a SpriteBatch as an argument since
     * when i was unit testing this class, i had to pass in a 'Mockito' sprite batch
     * to run the tests in a headless environment.
     * @param isHeadless for testing
     */
    public InstructionScreen(boolean isHeadless){

        super();

        this.table = new Table();
        this.skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));



        if(isHeadless){
            batch = new SpriteBatch();
        }
        else{
            this.batch = new SpriteBatch();
        }

        stage = new Stage(new ScreenViewport());

        font = new BitmapFont();
        font.getData().setScale(1.5f);
        labels = new ArrayList<>();


    }


    /**
     * adds the required labels on screen switch to this screen
     */
    public void addInstructions(){
        labels.add(new Label("To place a building,\n Left Click a building at bottom of the screen.\n " +
            "Then you can place the building on free land by Left Click on the exact spot. Caution This costs money (don't overspend now)",skin));
        labels.add(new Label("To remove a building,\n" +
            "simplify right click next to a building you want to remove you will then be refunded 80% of the buildings value back.",skin));
        labels.add(new Label("The goal of this game,\n is to achieve the highest satisfaction which means keeping on top of events and ensuring building are layed out well.",skin));
        labels.add(new Label("Achievements,\n are unlocked once you reach a certain score target.",skin));
        labels.add(new Label("To exit the game early or adjust settings during the game press ESCAPE KEY",skin));

        for (Label lbl : labels){
            lbl.setColor(Color.WHITE);
            lbl.setFontScale(1f);

            table.add(lbl).pad(5).align(Align.center);
            table.row();
        }
    }

    /**
     * simplifies adding the back button to being a function call on screen switch
     */
    public void addBackButton(){

        // Back button
        backBtn = new TextButton("Back", skin);

        backBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                ScreenUtils.OpenStartScreen();
                ScreenUtils.resetInputProcessor();
            }
        });


        // Add back button to table
        table.row();
        table.row();
        table.row();
        table.add(backBtn).pad(10).align(Align.center);

        stage.addActor(table);
    }

    public InstructionScreen() {
        this(false);
    }

    public InstructionScreen(SpriteBatch batch){
        this(true);
        this.batch = batch;
    }


    /**
     * Creates the title label for the leaderboard screen
     */
    public void createTitleLbl(){
        table.clear();
        // Create layout table
        table.setFillParent(true);
        table.top();
        table.center();
        labels.clear();

        Label title = new Label("INSTRUCTIONS", skin);
        title.setColor(Color.WHITE);
        title.setFontScale(3f);

        table.add(title).pad(3).align(Align.center);
        table.row();
        table.row();

        labels.add(title);

    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        com.badlogic.gdx.utils.ScreenUtils.clear(Color.BLACK);
        Drawer.drawAll();


        //System.out.println("Rendering leaderboard");
        batch.begin();

        stage.act(delta);
        stage.draw();
        batch.end();
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

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
        font.dispose();
    }

    public void takeInput(){
        Gdx.input.setInputProcessor(stage);
    }
}
