package com.vikingz.UI.Components;


import com.vikingz.UI.Screens.GameplayScreen;
import com.vikingz.Util.ScreenUtils;
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
public class BankruptMenu extends Window {


    /**
     * Creates a new pause menu
     * This menu is shown when the user pauses the game / presses
     *  the esc button during the game.
     * @param skin Contains the skin pack to be used with menu
     */
    public BankruptMenu(Skin skin) {

        super("", skin);

        this.setSize(800, 400);
        this.setModal(true);
        this.setMovable(false);
        this.setResizable(false);

        Label message = new Label("Whoops looks like you're out of money to do that action", skin);
        this.add(message).padBottom(20).row();
        this.setBackground(new TextureRegionDrawable(new Texture("png/background.png")));

        TextButton quitBtn = new TextButton("Dismiss", skin);
        this.add(quitBtn).pad(10);

        // Created for yes - no game events
        // The Popup needs to call back to parent object in someway
        quitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                com.vikingz.Util.ScreenUtils.resetInputProcessor();
                ((GameplayScreen) ScreenUtils.gameplayScreen).setPaused(false);
                ((GameplayScreen) ScreenUtils.gameplayScreen).setBankrupt(false);
                remove();
            }
        });
    }
}
