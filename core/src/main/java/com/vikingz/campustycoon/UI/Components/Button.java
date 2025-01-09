package com.vikingz.campustycoon.UI.Components;

import java.util.List;
import java.util.function.Consumer;

import com.vikingz.campustycoon.Game.GameLogic.Event;
import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.Util.GameUtils;
import com.vikingz.campustycoon.Util.MapUtils;
import com.vikingz.campustycoon.Util.ScreenUtils;

/**
 * This class is used to create a button.
 */
public class Button extends Component {
	public int value; // Used to carry information about which button was pressed (i.e. in events)

	/**
	 * Constructor for the Button class.
	 * @param X
	 * @param Y
	 * @param Width
	 * @param Height
	 */
	public Button(float X, float Y, float Width, float Height) {
		super(X, Y, Width, Height);
	}

	/**
	 * Constructor for the Button class.
	 * @param imagePath
	 * @param X
	 * @param Y
	 * @param Width
	 * @param Height
	 */
	public Button(String imagePath, float X, float Y, float Width, float Height) {
		super(imagePath, X, Y, Width, Height);
	}

	/**
	 * Constructor for the Button class.
	 * @param imagePaths
	 * @param X
	 * @param Y
	 * @param Width
	 * @param Height
	 */
	public Button(List<String> imagePaths, float X, float Y, float Width, float Height) {
		super(imagePaths, X, Y, Width, Height);
	}


	/**
	 * This method is used to open the start screen.
	 * @param isAction 
	 */
	protected static void openStartScreen(Boolean isAction) {
		ScreenUtils.OpenStartScreen();
		System.out.println("Screen changed to StartScreen");
	}

	/**
	 * This method is used to open the gameplay screen.
	 * @param isAction 
	 */
	protected static void openGameplayScreen(Boolean isAction) {
		ScreenUtils.openGameplayScreen();
		System.out.println("Screen changed to GameplayScreen");
	}

	/**
	 * This method is used to open the settings screen.
	 * @param isAction
	 */
    protected static void openSettingsScreen(Boolean isAction){
        ScreenUtils.openSettingsScreen();
        System.out.println("Screen changed to Settings screen");
    }

	/**
	 * This method is used to open the leaderboard screen.
	 * @param isAction
	 */
    protected static void openLeaderboardScreen(Boolean isAction){
		ScreenUtils.openLeaderboardScreen();
		System.out.println("Screen changed to Leaderboard screen");
	}

	/**
	 * Opens event popup
	 * @param isAction
	 */
	protected static void openEventPopup(Boolean isAction) {
		GameUtils.currentEvent = new Event();
		System.out.println("Event opened");
	}

	/**
	 * Closes event popup
	 * @param isAction
	 */
	protected static void closeEventPopup(Boolean isAction) {
		GameUtils.currentEvent.eventUI.close();
		System.out.println("Event closed");
	}

	/**
	 * Chooses an event option
	 * @param isAction
	 */
	protected void chooseEventOption(Boolean isAction) {
		GameUtils.currentEvent.chooseOption(value);
	}


	// Toggles which building is being placed.

	public static void toggleAccommodationBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.AccommodationBuilding);
		printBuildingChange();
	}
	public static void toggleStudyBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.StudyBuilding);
		printBuildingChange();
	}
	public static void toggleCafeteriaBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.CafeteriaBuilding);
		printBuildingChange();
	}
	public static void toggleRelaxationBuilding(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.RelaxationBuilding);
		printBuildingChange();
	}

	public static void toggleRelaxation2Building(Boolean isAction) {
		GameUtils.map.toggleBuildingPlacement(MapUtils.Placement.RelaxationBuilding2);
		printBuildingChange();
	}

	public static void printBuildingChange() {
		System.out.println(
			"Toggled building placement mode to: " + GameUtils.map.placing +
			"\nToggled building placement type to: " + GameUtils.map.placementType);
	}


	@Override
	/**
	 * 	Based on the action, decides what happens.
	 *  @param Actions The actions to be done.
	 */
	public void setClickAction(String Action) {
		Consumer<Boolean> action = a -> none(a);
		switch (Action) {
			// Screen changes
			case Actions.OpenStartScreen:
				action = a -> openStartScreen(a);
				break;
			case Actions.OpenGameplayScreen:
				action = a -> openGameplayScreen(a);
				break;

            case Actions.OpenLeaderboardScreen:
                action = a -> openLeaderboardScreen(a);
                break;

            case Actions.OpenSettingsScreen:
                action = a -> openSettingsScreen(a);
                break;

            // Events
			case Actions.OpenEventPopup:
				action = a -> openEventPopup(a);
				break;
			case Actions.CloseEventPopup:
				action = a -> closeEventPopup(a);
				break;

			case Actions.ChooseEventOption:
				action = a -> chooseEventOption(a);
				break;


			// Building toggles
			case Actions.ToggleAccommodationBuilding:
				action = a -> toggleAccommodationBuilding(a);
				break;
			case Actions.ToggleStudyBuilding:
				action = a -> toggleStudyBuilding(a);
				break;
			case Actions.ToggleCafeteriaBuilding:
				action = a -> toggleCafeteriaBuilding(a);
				break;
			case Actions.ToggleRelaxationBuilding:
				action = a -> toggleRelaxationBuilding(a);
				break;

			case Actions.ToggleRelaxation2Building:
				action = a -> toggleRelaxation2Building(a);
				System.out.println("Relax2");

			default:
				System.out.println("Invalid action passed to button: " + this.toString());
				break;
		}
		clickAction = action;
	}

}
