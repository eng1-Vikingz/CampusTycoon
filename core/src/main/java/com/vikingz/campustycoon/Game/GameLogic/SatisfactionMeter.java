package com.vikingz.campustycoon.Game.GameLogic;

import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.UI.Components.Component;
import java.util.Objects;

/**
 * This class is used to manage the satisfaction meter.
 */
public class SatisfactionMeter {
	public static Component satisfactionText;
    private static int satisfactionScore = 0;
    private static int satisfactionModifier = 0;

    /**
     * Gets the satisfaction score.
     * @return the satisfaction score
     */
    public static int getSatisfactionScore() {
        return satisfactionScore;
    }

    /**
     * Updates the satisfaction score based on a satisfaction formula.
     */
    public static void updateSatisfactionScore() {
        satisfactionScore = 0;

        for (int i = 0; i < Map.buildings.size(); i++){
            // Loop through all buildings and check distance etc
            double distance;

            if (Objects.equals(Map.buildings.get(i).buildingName, "ACCOMMODATION")){
                for (int j = 0; j < Map.buildings.size(); j++){
                    // Distance falloff function
                    distance = Math.sqrt(Math.pow((Map.buildings.get(i).position.x - Map.buildings.get(j).position.x), 2) + Math.pow((Map.buildings.get(i).position.y - Map.buildings.get(j).position.y), 2));
                    satisfactionScore += (int) Math.round(Map.buildings.get(j).score * (-Math.tanh(0.05 * distance - 0.5) + 1));
                }
            }

            if (Objects.equals(Map.buildings.get(i).buildingName, "RELAXATION")){
                for (int j = 0; j < Map.buildings.size(); j++){
                    // Distance falloff function
                    distance = Math.sqrt(Math.pow((Map.buildings.get(i).position.x - Map.buildings.get(j).position.x), 2) + Math.pow((Map.buildings.get(i).position.y - Map.buildings.get(j).position.y), 2));
                    if (distance <= 3){
                        satisfactionScore += 1;
                    }
                }
            }
        }

		SatisfactionMeter.updateDisplay();
    }

    /**
     * Modifies the satisfaction score.
     * @param value int
     */
    public static void modifySatisfactionScore(int value) {
        satisfactionModifier += value;
		SatisfactionMeter.updateDisplay();
    }

    /**
     *  Updates the display.
     */
	public static void updateDisplay() {
		if (satisfactionText == null) {
			return;
		}
        satisfactionScore += satisfactionModifier;
		satisfactionText.text = String.valueOf(satisfactionScore);
	}
}
