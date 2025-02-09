package com.vikingz.campustycoon.UI.Components;


import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.Util.ScreenUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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
public class PauseMenu extends Window {

    public TextButton settingsBtn, quitBtn;

    /**
     * Creates a new pause menu
     * This menu is shown when the user pauses the game / presses
     *  the esc button during the game.
     * @param skin Contains the skin pack to be used with menu
     */
    public PauseMenu(Skin skin) {

        super("", skin);

        this.setSize(800, 400);
        this.setModal(true);
        this.setMovable(false);
        this.setResizable(false);

        Label message = new Label("Game Paused\n(Click esc to un-pause) ", skin);
        this.add(message).padBottom(20).row();
        this.setBackground(new TextureRegionDrawable(new Texture("png/background.png")));


        settingsBtn = new TextButton("Settings", skin);

        quitBtn = new TextButton("Quit", skin);
        this.add(settingsBtn).pad(10);
        this.add(quitBtn).pad(10);

        // Created for yes - no game events
        // The Popup needs to call back to parent object in someway

        settingsBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenUtils.resetInputProcessor();
                ScreenUtils.openSettingsScreen();
                ((GameplayScreen) ScreenUtils.gameplayScreen).setPaused(false);
                remove();
            }
        });

        quitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenUtils.resetInputProcessor();
                ScreenUtils.OpenEndScreen();
                ((GameplayScreen) ScreenUtils.gameplayScreen).setPaused(false);
                ((GameplayScreen) ScreenUtils.gameplayScreen).getAchievementHandle().checkForAchieved();
                remove();

            }
        });
    }

}
