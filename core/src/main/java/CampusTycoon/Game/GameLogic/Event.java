package CampusTycoon.Game.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import CampusTycoon.UI.Systems.EventPopup;
import CampusTycoon.Util.GameUtils;

public class Event {
	public EventPopup eventUI;
	public int choices; // Number of choices for the event
	public String eventText; // Description of the event
    public String event; // event
	public List<String> choiceText; // Text to be displayed in the choice buttons (NOT IMPLEMENTED)

	public Event() {
		choices = 3;
		choiceText = new ArrayList<String>(Arrays.asList(
			"Accept", "Neutral", "Reject"));

        event =  EventLoader.getEvent();
        eventText = EventLoader.getEventDescription(event);

		eventUI = new EventPopup(this);
		eventUI.initialise();
	}

	public void chooseOption(int option) {
		if (option > choices) {
			System.out.print("Invalid event choice");
			return;
		}

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

	// Temporary choice implementations, will change to abstract functions later (as each individual event should decide what the outcome of choices are)
	public void acceptOption() {
		SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("accept",event));
        allowChoice("accept");
    }
	public void neutralOption() {
        SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("neutral",event));
        allowChoice("neutral");
    }
	public void rejectOption() {
        SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("reject",event));
        allowChoice("reject");
    }

    private void allowChoice(String reject) {
        if (MoneyHandler.addMoney(-EventLoader.getActionCost(reject, event))) {
            this.End();
        } else {
            //todo add alerts
            System.out.println("player is out of money");
        }
    }

    public void End() {
		eventUI.close();
		GameUtils.currentEvent = null;
	}
}
