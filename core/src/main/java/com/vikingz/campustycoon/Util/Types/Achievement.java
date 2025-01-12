package com.vikingz.campustycoon.Util.Types;

import com.vikingz.campustycoon.Util.Achievements;

public class Achievement {
    public final String name;
    public final Achievements.AchievementTargetTypes type;
    public final int target;

    private boolean achieved = false;

    /***
     * initialises a new achievement object for easier handling
     * @param name name of achievement
     * @param type type of achievement (what stat are tracking)
     * @param target the goal for the achievement to be checked
     */
    public Achievement(String name, Achievements.AchievementTargetTypes type,int target){
        this.name = name;
        this.type = type;
        this.target = target;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void hasBeenAchieved() {
        this.achieved = true;
    }

}
