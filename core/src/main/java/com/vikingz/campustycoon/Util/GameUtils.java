package com.vikingz.campustycoon.Util;

import java.util.Arrays;
import java.util.List;

import com.vikingz.campustycoon.Game.Buildings.*;
import com.vikingz.campustycoon.Game.GameLogic.*;
import com.vikingz.campustycoon.Game.Maps.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import com.vikingz.campustycoon.UI.Camera;
import com.vikingz.campustycoon.UI.Components.Backdrop;
import com.vikingz.campustycoon.UI.Components.Button;
import com.vikingz.campustycoon.UI.Components.Component;
import com.vikingz.campustycoon.UI.Components.MenuText;
import com.vikingz.campustycoon.UI.Components.Component.Actions;
import com.vikingz.campustycoon.UI.Components.Component.Anchor;

/**
 * This class provides utility functions for the game.
 * Such as setting up certain game objects etc.
 */
public class GameUtils {
	public static Map map;
	public static Event currentEvent;




	public static void startGame() {
		map = new Map();
		Camera.map = map;
	}

	// Gets the image used for hover displays (just a semi-transparent version of the original)


	/**
	 * CHANGED: This was a
	 * @param originalImage
	 * @return
	 */
	public static String getHoverImagePath(String originalImage){
		if(!originalImage.isEmpty()){
			return originalImage.replace(".png", "Transparent.png");
		}
		return "MissingTexture.png";

	}

	/**
	 * Creates startmenu ui
	 */
	public static void createStartMenuUI() {
        Button buttonNewGame = new Button("New Game.png", 0, 90, 262, 66);
		buttonNewGame.setClickAction(Actions.OpenGameplayScreen);
        buttonNewGame.setAnchor(Anchor.Centre);

        Button buttonAchievement = new Button("Achievements.png", 0, 20, 262, 66);
        buttonAchievement.setClickAction(Actions.OpenAchievementScreen);
        buttonAchievement.setAnchor(Anchor.Centre);

        Button buttonInstructions = new Button("Instructions.png", 0, -50, 262, 66);
        buttonInstructions.setClickAction(Actions.OpenInstructionScreen);
        buttonInstructions.setAnchor(Anchor.Centre);

        Button buttonLeaderboard = new Button("Leaderboard.png", 0, -120, 262, 66);
        buttonLeaderboard.setClickAction(Actions.OpenLeaderboardScreen);
        buttonLeaderboard.setAnchor(Anchor.Centre);

        Button buttonSettings = new Button("Settings.png", 0, -190, 262, 66);
        buttonSettings.setClickAction(Actions.OpenSettingsScreen);
        buttonSettings.setAnchor(Anchor.Centre);


        List<Component> startScreenButtonList = Arrays.asList(
			buttonNewGame,
			buttonLeaderboard,
            buttonAchievement,
            buttonInstructions,
			buttonSettings);

		// Add all buttons to the drawQueue
		for (Component button : startScreenButtonList) {
			// All added to layer '1' (generally on top of most other UI elements)
			Drawer.add(1, button);
		}

		// Add all buttons to the InputHandler to allow for interaction handling
		// (Allows buttons to be clicked and things to actually happen)
		InputHandler.add(startScreenButtonList);
	}

	/**
	 * Creates the UI for the gameplay screen
	 */
	public static void createGameplayUI() {


		//setupMenu();


		Button buttonAccommodation = new Button("Buildings\\acom1.png", -250, 10, 90, 66);
		buttonAccommodation.setClickAction(Actions.ToggleAccommodationBuilding);
		buttonAccommodation.setAnchor(Anchor.BottomCentre);

		MenuText accommodationCount = new MenuText(
			String.valueOf(BuildingCounter.getBuildingCount(Accommodation.buildingName)),
			-260, 110, 2f, 2f);
		accommodationCount.setAnchor(Anchor.BottomCentre);
		BuildingCounter.UI.add(accommodationCount);


		// ORIGINAL STUDY BTN
        Button buttonStudy = new Button("Buildings\\rch1.png", -150, 10, 90, 66);
		buttonStudy.setClickAction(Actions.ToggleStudyBuilding);
        buttonStudy.setAnchor(Anchor.BottomCentre);

		MenuText studyCount = new MenuText(
			String.valueOf(BuildingCounter.getBuildingCount(Study.buildingName)),
			-160, 110, 2f, 2f);
		studyCount.setAnchor(Anchor.BottomCentre);
		BuildingCounter.UI.add(studyCount);



        Button buttonCafe = new Button("Buildings\\macd.png", -50, 10, 90, 66);
		buttonCafe.setClickAction(Actions.ToggleCafeteriaBuilding);
        buttonCafe.setAnchor(Anchor.BottomCentre);

		MenuText cafeCount = new MenuText(
			String.valueOf(BuildingCounter.getBuildingCount(Cafeteria.buildingName)),
			-60, 110, 2f, 2f);
		cafeCount.setAnchor(Anchor.BottomCentre);
		BuildingCounter.UI.add(cafeCount);


        Button buttonRelax = new Button("Buildings\\ysv.png", 50, 10, 90, 66);
		buttonRelax.setClickAction(Actions.ToggleRelaxationBuilding);
        buttonRelax.setAnchor(Anchor.BottomCentre);

        Button buttonRelax2 = new Button("Buildings\\pub.png", 150, 10, 90, 66);
		buttonRelax2.setClickAction(Actions.ToggleRelaxation2Building);
        buttonRelax2.setAnchor(Anchor.BottomCentre);

		MenuText relaxCount = new MenuText(
			String.valueOf(BuildingCounter.getBuildingCount(Relaxation.buildingName)),
			95, 110, 2f, 2f);
		relaxCount.setAnchor(Anchor.BottomCentre);
		BuildingCounter.UI.add(relaxCount);


        // Button buttonPH5 = new Button("Placeholder.png", 150, 10, 90, 66);
        // buttonPH5.setAnchor(Anchor.BottomCentre);



        Button buttonDollar = new Button("Dollar.png", -300, 0, 70, 66);
        buttonDollar.setAnchor(Anchor.TopCentre);

        Button buttonHouses = new Button("House.png", 0, 0, 70, 66);
        buttonHouses.setAnchor(Anchor.TopCentre);

        Button buttonPeople = new Button("Person.png", 300, 0, 60, 66);
        buttonPeople.setAnchor(Anchor.TopCentre);


        //event
        /*
        Button notif1 = new Button("ExclamationMark.png", -12, 0, 100, 80);
        notif1.setClickAction(Actions.OpenEventPopup);
        notif1.setAnchor(Anchor.TopLeft);


        Button notif2 = new Button("QuestionMark.png", 0, 80, 80, 80);
        notif2.setClickAction(Actions.OpenEventPopup);
        notif2.setAnchor(Anchor.TopLeft);
        */

        Button buttonSatisfaction = new Button("Satisfaction.png", 100, 10, 200, 66);
        buttonSatisfaction.setAnchor(Anchor.TopRight);


		List<Component> UIButtons = Arrays.asList(
			buttonAccommodation, buttonStudy, buttonCafe, buttonRelax, buttonRelax2,
			buttonSatisfaction,
			buttonDollar, buttonHouses, buttonPeople);

		// Add all buttons to the drawQueue
		for (Component button : UIButtons) {
			// All added to layer '1' (generally on top of most other UI elements)
			Drawer.add(1, button);
		}

		// Add all buttons to the InputHandler to allow for interaction handling
		InputHandler.add(UIButtons);

        MenuText satisfactionText = new MenuText("", 80, 30, 2f, 2f);
        satisfactionText.setAnchor(Anchor.TopRight);
		SatisfactionMeter.satisfactionText = satisfactionText;
		SatisfactionMeter.updateDisplay();

        //MenuText notifText1 = new MenuText("Notification 1", 130, 23, 1.5f, 1.5f);
		//notifText1.setAnchor(Anchor.TopLeft);

        //MenuText notifText2 = new MenuText ("Notification 2", 135, 105, 1.5f, 1.5f);
        //notifText2.setAnchor(Anchor.TopLeft);

		MenuText buildingCounterText = new MenuText(String.valueOf(BuildingCounter.getTotalBuildingCount()), 70, 25, 2f, 2f);
		buildingCounterText.setAnchor(Anchor.TopCentre);
		BuildingCounter.totalCountUI = buildingCounterText;

		MenuText timerText = new MenuText("Time: " + Timer.getTimeRemaining(), 180, 100, 2f, 2f);
		timerText.setAnchor(Anchor.TopRight);
		Timer.text = timerText;

        MenuText moneyText = new MenuText(Integer.toString(MoneyHandler.getMoney()),-230,25,2f,2f);
        moneyText.setAnchor(Anchor.TopCentre);
        MoneyHandler.text = moneyText;

		MenuText helpPrompts = new MenuText("press esc to pause",00,25,2f,2f);
        helpPrompts.setAnchor(Anchor.TopLeft);


        List<Component> textElements = Arrays.asList(helpPrompts, satisfactionText, buildingCounterText, accommodationCount,
            studyCount, cafeCount, relaxCount, timerText,helpPrompts, moneyText);

		// Add all text to the drawQueue
		for (Component text : textElements) {
			// All added to layer '2' (on top of almost all other UI elements)
			Drawer.add(2, text);
		}
		// No need to add text to the InputHandler (unless you really want to be able to click on it for some reason)
	}


	/**
	 * Creates event popup ui
	 * @param event
	 */
	public static void createEventPopupUI(Event event) {
        Backdrop eventScreenBackdrop = new Backdrop("Backdrop.png", 0, 30, 400, 350);
        eventScreenBackdrop.setAnchor(Anchor.Centre);
		eventScreenBackdrop.update();
		event.eventUI.elements.add(eventScreenBackdrop);
        Drawer.add(1, eventScreenBackdrop); // Layer 1 so its behind the rest of the UI

        Button buttonAccept = new Button("Accept.png", -130, -106, 126, 66);
        buttonAccept.setClickAction(Actions.ChooseEventOption);
        buttonAccept.setAnchor(Anchor.Centre);
		buttonAccept.value = 1; // Used so the Event class knows which button was clicked

        Button buttonNeutral = new Button("Neutral.png", 0, -106, 126, 66);
        buttonNeutral.setClickAction(Actions.ChooseEventOption);
        buttonNeutral.setAnchor(Anchor.Centre);
		buttonNeutral.value = 2;

        Button buttonReject = new Button("Reject.png", 130, -106, 126, 66);
        buttonReject.setClickAction(Actions.ChooseEventOption);
        buttonReject.setAnchor(Anchor.Centre);
		buttonReject.value = 3;

        List<Component> eventChoices = Arrays.asList(buttonAccept, buttonReject, buttonNeutral);

		for (Component button : eventChoices) {
			// All added to layer '2' (on top of almost all other UI elements)
			button.update();
			event.eventUI.elements.add(button);
			Drawer.add(2, button);
		}
        InputHandler.add(eventChoices);
		event.eventUI.buttonElements = eventChoices;

        //MenuText eventTextTitle = new MenuText("Event 1", 0, 0, 0, 0);
        //eventTextTitle.setAnchor(Anchor.Centre);
		MenuText testText = new MenuText(
			event.eventText,
			-eventScreenBackdrop.getBaseWidth() / 2 + eventScreenBackdrop.getBaseX() + 15,
			eventScreenBackdrop.getBaseHeight() / 2 + eventScreenBackdrop.getBaseY() - 12,
			1.5f, 1.5f);
		testText.setAnchor(Anchor.Centre);
		testText.update();
		event.eventUI.elements.add(testText);
        Drawer.add(2, testText);

	}


	/**
	 * Sets up menu
	 */
	public static void setupMenu(){


        //Texture atlas of building menu bar
        Texture btn1Texture = new Texture(Gdx.files.internal("Buildings\\Study.png"));
        Texture btn2Texture = new Texture(Gdx.files.internal("Buildings\\Study.png"));
        Texture btn3Texture = new Texture(Gdx.files.internal("Buildings\\Study.png"));
        Texture btn4Texture = new Texture(Gdx.files.internal("Buildings\\Study.png"));

        Texture btn1TextureHover = new Texture(Gdx.files.internal("Buildings\\StudyTransparent.png"));



		ImageButton btn1 = new ImageButton(new ImageButton.ImageButtonStyle());
        btn1.getStyle().imageUp = new TextureRegionDrawable(btn1Texture);
		btn1.getStyle().imageOver = new TextureRegionDrawable(btn1TextureHover);

        ImageButton btn2 = new ImageButton(new ImageButton.ImageButtonStyle());
        btn2.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(btn2Texture));

        ImageButton btn3 = new ImageButton(new ImageButton.ImageButtonStyle());
        btn3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(btn3Texture));

        ImageButton btn4 = new ImageButton(new ImageButton.ImageButtonStyle());
        btn4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(btn4Texture));


        // Table for layout
        Table table = new Table();
        table.setFillParent(true);
        table.bottom().center();
        table.bottom();

        // Add buttons to table
        table.add(btn1).pad(10);
        table.add(btn2).pad(10);
        table.add(btn3).pad(10);
        table.add(btn4).pad(10);

        // Add table to stage

        // Set up click listeners for buttons
        btn1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
				System.out.println("pressed btn1");

			}
        });

        btn2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {


            }
        });

        btn3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        btn4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

			}
        });

        Drawer.stage.addActor(table);


	}



	/**
	 * Creates end screen ui
	 */
	public static void createEndScreenUI() {
        Button buttonNewGame = new Button("New Game.png", 0, 20, 262, 66);
		buttonNewGame.setClickAction(Actions.OpenGameplayScreen);
        buttonNewGame.setAnchor(Anchor.Centre);


		Button buttonMainMenu = new Button("Main Menu.png", 0, 90, 262, 66);
		buttonMainMenu.setClickAction(Actions.OpenStartScreen);
        buttonMainMenu.setAnchor(Anchor.Centre);


        List<Component> endScreenButtonList = Arrays.asList(
			buttonMainMenu,
			buttonNewGame);

		// Add all buttons to the drawQueue
		for (Component button : endScreenButtonList) {
			// All added to layer '1' (generally on top of most other UI elements)
			Drawer.add(1, button);
		}

		// Add all buttons to the InputHandler to allow for interaction handling
		// (Allows buttons to be clicked and things to actually happen)
		InputHandler.add(endScreenButtonList);
	}
}
