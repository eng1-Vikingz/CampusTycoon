package com.vikingz.campustycoon.UI.Components;


import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * This is a generic PopupMenu class that can create user defined
 * popups. This class is crucial for the implementation of random events
 * in the game during later development.
 *
 * The user can assign everything in the popup, all of the text displayed
 * as well as the runnable that run when the 2 buttons are pressed.
 */
public class PopupMenu extends Window {

    private String message = "";


    // Skin for the popup
    private final Skin skin;


    /**
     * Creates a new Popup menu
     * @param skin Skin for the menu
     * @param message Message to be displayed in the popup
     */
    public PopupMenu(Skin skin, String message) {

        super("Popup", skin);

        this.message = message;

        this.setSize(600, 400);
        this.setModal(true);
        this.setMovable(false);
        this.setResizable(false);

        this.skin = skin;


        Label messagelbl = new Label(message, skin);
        this.add(messagelbl).padBottom(20).row();

    }

    /**
     * Configures the 2 buttons that appear on the popup
     * @param leftRun Runnable that will be run if the left button is pressed
     * @param leftText The text written on the left button
     * @param rightRun Runnable that will be run if the right button is pressed
     * @param rightText The text written on the right button
     */
    public void setupButtons(Runnable leftRun, String leftText, Runnable rightRun, String rightText){


        TextButton leftBtn = new TextButton(leftText, skin);
        TextButton rightBtn = new TextButton(rightText, skin);

        this.add(leftBtn).pad(10);
        this.add(rightBtn).pad(10);

        // Created for yes - no game events
        // The Popup needs to call back to parent object in someway

        leftBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                leftRun.run();
                //PopupMenu.this.remove();
            }
        });

        rightBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                rightRun.run();
                //PopupMenu.this.remove();
            }
        });
    }


    /**
     * Configures on the right button with the left button being
     * closing the popup
     * @param rightRun Button runnable
     * @param rightText Button text
     */
    public void setupRightBtn(Runnable rightRun, String rightText){



        TextButton leftBtn = new TextButton("Close", skin);
        TextButton rightBtn = new TextButton(rightText, skin);

        this.add(leftBtn).pad(10);
        this.add(rightBtn).pad(10);

        // Created for yes - no game events
        // The Popup needs to call back to parent object in someway

        leftBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PopupMenu.this.remove();
            }
        });

        rightBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                rightRun.run();
            }
        });

    }

    //Getters and Setters
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }



}