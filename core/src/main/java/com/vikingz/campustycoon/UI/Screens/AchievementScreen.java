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
import com.vikingz.campustycoon.Util.Achievements;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.ScreenUtils;
import com.vikingz.campustycoon.Util.Types.Achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementScreen implements Screen {

    final int PADDING = 3;


    //Used to render UI
    private SpriteBatch batch;
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
    private Achievements achievements;

    public AchievementScreen(){
        this(false);
    }
    public AchievementScreen(boolean isHeadless){

        super();
        this.table = new Table();

        stage = new Stage();
        this.skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));


        if(isHeadless){
            batch = new SpriteBatch();
        }
        else{
            this.batch = new SpriteBatch();
        }

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

    }

    private void createTitleLbl(){
        Label title = new Label("Achievements", skin);
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

    @Override
    public void show() {
        stage.clear();
        table.clear();
        labels.clear();
        table.setFillParent(true);
        table.top();
        createTitleLbl();
        table.center();
        achievements = new Achievements("achievement.yml");
        ArrayList<Achievement> list = achievements.getAchievementList();
        achievements.checkForAchieved();
        for (Achievement achievement : list){
            if (achievements.achievedSet.contains(achievement.name)) {
                addLabel(achievement.name + " :: COMPLETED");
            }
            else{
                addLabel(achievement.name + " :: NOT COMPLETE");
            }

        }
        table.row();
        table.row();
        table.row();
        table.add(backBtn).pad(PADDING).align(Align.center);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        //clears screen
        com.badlogic.gdx.utils.ScreenUtils.clear(Color.BLACK);
        Drawer.drawAll();


        //System.out.println("Rendering leaderboard");
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
    public void resize(int width, int height) {
        resize((float) width,(float) height);
    }

    /**
     * disposes stats being drawn for garbage collection
     */
    public void dispose(){
        stage.dispose();
        batch.dispose();
        font.dispose();
    }

    public void takeInput(){
        Gdx.input.setInputProcessor(stage);
    }
}
