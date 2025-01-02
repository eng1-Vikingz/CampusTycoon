package com.vikingz.campustycoon.Game.GameLogic;

import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.UI.Components.Component;

import java.util.Objects;

public class SatisfactionMeter {
	public static Component satisfactionText;
    private static int satisfactionScore = 0;
    private static int satisfactionModifier = 0;

    public static int getSatisfactionScore() {
        return satisfactionScore;
    }

    public static void updateSatisfactionScore() {
        System.out.println("Satisfaction Function Called");
        satisfactionScore = 0;

        for (int i = 0; i < Map.buildings.size(); i++){
            // Loop through all buildings and check distance etc
            double distance;
            System.out.println(i);
            System.out.println(Map.buildings.get(i).buildingName);

            if (Objects.equals(Map.buildings.get(i).buildingName, "ACCOMMODATION")){
                for (int j = 0; j < Map.buildings.size(); j++){
                    // Distance falloff function
                    distance = Math.sqrt(Math.pow((Map.buildings.get(i).position.x - Map.buildings.get(j).position.x), 2) + Math.pow((Map.buildings.get(i).position.y - Map.buildings.get(j).position.y), 2));
                    System.out.println(distance);
                    System.out.println(Map.buildings.get(j).score);
                    satisfactionScore += (int) Math.round(Map.buildings.get(j).score * -Math.tanh(0.05 * distance - 0.5) + 1);
                }
            }
        }

		SatisfactionMeter.updateDisplay();
    }

    public static void modifySatisfactionScore(int value) {
        satisfactionModifier += value;
		SatisfactionMeter.updateDisplay();
    }

	public static void updateDisplay() {
		if (satisfactionText == null) {
			return;
		}
        satisfactionScore += satisfactionModifier;
		satisfactionText.text = String.valueOf(satisfactionScore);
	}
}
