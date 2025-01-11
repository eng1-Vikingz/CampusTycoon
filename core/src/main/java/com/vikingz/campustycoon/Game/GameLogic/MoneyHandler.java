package com.vikingz.campustycoon.Game.GameLogic;

import com.vikingz.campustycoon.UI.Components.MenuText;

/** basic class that handles the money counter
 *  prevents the player going into debt
 */
public class MoneyHandler {
    public static MenuText text;
    private static int money = 1000;
    private static float delayCheque = 4f;
    private static float delay = delayCheque;

    private static boolean previousBankrupt = false;

    /**
     * increase the money counter by change
     * @param change int
     * @return state boolean if the player will go into debt over this transaction
     */
    public static boolean addMoney(int change){
        //prevents going bankrupt
        if (money+change < 0){
            System.out.println("no money");
            previousBankrupt = true;
            return false;
        }
        else {
            money += change;
            return true;
        }
    }

    /**
     * Takes money from the player
     * @param amount
     * @return
     */
    public static boolean spendMoney(int amount){
        return addMoney(-amount);
    }

    /**
     * returns current money counter
     * @return money int
     */
    public static int getMoney() {
        return money;
    }

    /**
     * returns if a user tried to go into bankruptcy
     * @return previousBankrupt boolean
     */
    public static boolean isPreviousBankrupt() {
        return previousBankrupt;
    }

    /**
     * Resets the money counter to 1000
     */
    public static void resetBank(){
        money = 1000;
    }

    /**
     * updates money text with current balance
     */
    public static void update(float delta){
        if (delay <= 0){
            income();
            delay = delayCheque;
        }
        delay -= delta;

        try {
            text.text = Integer.toString(getMoney());
        }
        catch (Exception e){
            System.err.println("update called before money had been a text object.");
        }
    }

    //Todo better formula
    public static void income(){
        addMoney(SatisfactionMeter.getSatisfactionScore()-BuildingCounter.getTotalBuildingCount()*45);
    }

}
