package CampusTycoon.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import CampusTycoon.GameUtils;
import CampusTycoon.UI.Systems.EventPopup;

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
		this.End();
	}
	public void neutralOption() {
        SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("neutral",event));
        this.End();
	}
	public void rejectOption() {
        SatisfactionMeter.modifySatisfactionScore(EventLoader.getActionGain("reject",event));
        //Add money
		this.End();
	}

	public void End() {
		eventUI.close();
		GameUtils.currentEvent = null;
	}
}
