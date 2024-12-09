package CampusTycoon.UI;


import java.util.ArrayList;
import java.util.List;

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


    public LeaderboardScreen() {

        super();

        this.skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));

        batch = new SpriteBatch();
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

        addLabel("TEST1");
        addLabel("TEST2");
        addLabel("TEST3");




        for(Label lbl: labels){
            lbl.setColor(Color.WHITE);
            lbl.setFontScale(1.5f);
        }


        // Add back button to table
        table.add(backBtn).pad(PADDING).align(Align.center);

        stage.addActor(table);

    }


    private void addLabel(String text){
        Label lbl = new Label(text, this.skin);
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
    }

    public void takeInput(){
        Gdx.input.setInputProcessor(stage);
    }

}
