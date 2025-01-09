package com.vikingz.campustycoon.UI.Systems;

import com.badlogic.gdx.utils.Array;
import com.vikingz.campustycoon.Game.GameLogic.Event;
import com.vikingz.campustycoon.UI.Components.Component;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.GameUtils;
import com.vikingz.campustycoon.Util.InputHandler;

import java.util.List;
import java.util.ArrayList;

/**
 * This class is used to create an event popup.
 * 
 */
public class EventPopup {
	public Event event;
	public static List<Component> elements = new ArrayList<Component>();
	public static List<Component> buttonElements = new ArrayList<Component>();
	
    public EventPopup(Event Event) {
		event = Event;
    }
	
	/**
	 * Initialises the event popup.
	 */
	public void initialise() {
		GameUtils.createEventPopupUI(event);
	}

	/**
	 * Closes the popup
	 */
    public void close() {
		for (Component element : buttonElements) { 
			InputHandler.remove(element);
		}
		
		for (Component element : elements) { 
			Drawer.remove(0, element);
		}
    }

	public static void addElement(Component element) {
		elements.add(element);
	}

	public static Component getLastElement() {
		return elements.get(elements.size() - 1);
	}
}
