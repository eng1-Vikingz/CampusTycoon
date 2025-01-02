package com.vikingz.UI.Systems;

import com.vikingz.Game.GameLogic.Event;
import com.vikingz.UI.Components.Component;
import com.vikingz.Util.Drawer;
import com.vikingz.Util.GameUtils;
import com.vikingz.Util.InputHandler;

import java.util.List;
import java.util.ArrayList;

public class EventPopup {
	public Event event;
	public List<Component> elements;
	public List<Component> buttonElements; // Only elements which are passed to the InputHandler
	
    public EventPopup(Event Event) {
		event = Event;
    }
	
	public void initialise() {
		elements = new ArrayList<Component>();
		buttonElements = new ArrayList<Component>();
		GameUtils.createEventPopupUI(event);
	}

    public void close() {
		for (Component element : buttonElements) { 
			InputHandler.remove(element);
		}
		
		for (Component element : elements) { 
			Drawer.remove(0, element);
		}
    }
}
