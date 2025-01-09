package com.vikingz.campustycoon.UI.Components;


import com.vikingz.campustycoon.Game.GameLogic.BuildingCounter;
import com.vikingz.campustycoon.Game.GameLogic.SatisfactionMeter;
import com.vikingz.campustycoon.Game.GameLogic.Timer;
import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.UI.Screens.LeaderboardScreen;
import com.vikingz.campustycoon.Util.GameSounds;
import com.vikingz.campustycoon.Util.LeaderboardFileHandler;
import com.vikingz.campustycoon.Util.ScreenUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 *  This class represents a PauseMenu in the game.
 *
 * This is the menu that appears if the user pressed the esc button
 * during the game.
 *
 * This menu contains a settings button which sends the user to the settings
 * screen from which they can edit the settings.
 *
 * To close the pause menu, the user has to press the esc button again.
 */
public class LeaderboardNewEntryMenu extends Window {

    public TextButton addEntryBtn;
    private Timer timer;
    /**
     * Creates a new pause menu
     * This menu is shown when the user pauses the game / presses
     *  the esc button during the game.
     * @param skin Contains the skin pack to be used with menu
     */
    public LeaderboardNewEntryMenu(Skin skin, Timer t) {

        super("", skin);

        this.setSize(800, 400);
        this.setModal(true);
        this.setMovable(false);
        this.setResizable(false);

        Label message = new Label("Enter your name to add your score\n to the leaderboard!", skin);
        this.add(message).padBottom(20).row();

        Label errorMessage = new Label("", skin);
        this.add(errorMessage).padBottom(20).row();

        this.setBackground(new TextureRegionDrawable(new Texture("png/background.png")));

        TextField nameField = new TextField("", skin);

        addEntryBtn = new TextButton("AddNewEntry", skin);

        this.add(nameField).pad(10).row();
        this.add(addEntryBtn).pad(10).row();

        // Created for yes - no game events
        // The Popup needs to call back to parent object in someway

        addEntryBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if(nameField.getText().isEmpty()){
                    GameSounds.playPlaceError();
                    errorMessage.setText("Name cannot be empty!");
                    return;
                }

                LeaderboardFileHandler.addLeaderboardEntry(nameField.getText(), SatisfactionMeter.getSatisfactionScore());
                //timer.closeMenu();  
                remove();   

                com.vikingz.campustycoon.Util.ScreenUtils.resetInputProcessor();
                ScreenUtils.OpenEndScreen();
                BuildingCounter.reset();           
                ScreenUtils.resetInputProcessor();
                ScreenUtils.openLeaderboardScreen();

            }
        });


    }

}
