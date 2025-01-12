package com.vikingz.campustycoon.Game.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.vikingz.campustycoon.UI.Screens.GameplayScreen;
import com.vikingz.campustycoon.UI.Systems.EventPopup;
import com.vikingz.campustycoon.Util.GameSounds;
import com.vikingz.campustycoon.Util.GameUtils;
import com.vikingz.campustycoon.Util.ScreenUtils;

/**
 * This class is used to create and manage an events.
 */
public class Event {
	public EventPopup eventUI;
	public int choices; // Number of choices for the event
	public String eventText; // Description of the event
    public String event; // event
	public List<String> choiceText; // Text to be displayed in the choice buttons (NOT IMPLEMENTED)

    /**
     * Constructor for Event.
     */
	public Event() {
		choices = 3;
		choiceText = new ArrayList<String>(Arrays.asList(
			"Accept", "Neutral", "Reject"));

        event =  EventLoader.getEvent();
        eventText = EventLoader.getEventDescription(event);

		eventUI = new EventPopup(this);
		eventUI.initialise();
	}

    /**
     * Chooses an option for the event.
     * @param option
     */
	public void chooseOption(int option) {
		if (option > choices) {
			System.out.print("Invalid event choice");
			return;
		}
        // Switch statement to determine which option was chosen
		switch (option) {
			case 1:
				acceptOption();
				break;
			case 2:
				neutralOption();
				break;
			case 3:
				rejectOption();
				break;
			default:
				System.out.print("Invalid event choice");
				break;
		}
	}

    
    /**
     * Accepts the event.
     */
	public void acceptOption() {
        if (allowChoice("accept")) {
            SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("accept", event));
            this.End();
        }
        else{
            ((GameplayScreen) ScreenUtils.gameplayScreen).displayBankruptWarning();
            GameSounds.playPlaceError();
        }
    }

    /**
     * Neutral option for the event.
     */
	public void neutralOption() {
        if (allowChoice("neutral")) {
            SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("neutral", event));
            this.End();
        }
        else{
            ((GameplayScreen) ScreenUtils.gameplayScreen).displayBankruptWarning();
            GameSounds.playPlaceError();
        }
    }

    /**
     * Rejects the event.
     */
	public void rejectOption() {
        if (allowChoice("reject")) {
            SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("reject", event));
            this.End();
        }
        else{
            ((GameplayScreen) ScreenUtils.gameplayScreen).displayBankruptWarning();
            GameSounds.playPlaceError();
        }
    }

    /**
     * Checks if the player has enough money to make a choice.
     * @param choice The choice to be made.
     * @return
     */
    private boolean allowChoice(String choice) {
        if (MoneyHandler.addMoney(-EventLoader.getActionCost(choice, event))) {
            return true;
        } else {
            System.out.println("no money");
            return false;
        }
    }

    /**
     * Ends the event.
     */
    public void End() {
		eventUI.close();
		GameUtils.currentEvent = null;
	}
}
