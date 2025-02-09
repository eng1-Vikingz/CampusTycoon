package com.vikingz.campustycoon.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import java.util.Random;

public class GameSounds {

    // Load the sounds fx
    private static final Sound placeBuilding1 = Gdx.audio.newSound(Gdx.files.internal("audio/place_1.ogg"));
    private static final Sound placeBuilding2 = Gdx.audio.newSound(Gdx.files.internal("audio/place_2.ogg"));
    private static final Sound placeBuilding3 = Gdx.audio.newSound(Gdx.files.internal("audio/place_3.ogg"));

    private static final Sound placeError1 = Gdx.audio.newSound(Gdx.files.internal("audio/place_error_1.ogg"));
    private static final Sound placeError2 = Gdx.audio.newSound(Gdx.files.internal("audio/place_error_2.ogg"));

    //Sets the volume of the GameSounds to be played
    public static float volume = 1f;

    // Could be useful for more sounds later on
    // private static final ArrayList<Sound> sounds = new ArrayList<>() {
    //     {
    //         add(placeBuilding1);
    //         add(placeBuilding2);
    //         add(placeBuilding3);
    //         add(placeError1);
    //         add(placeError2);
    //     }
    // };

    /**
     * Plays the placed building sound
     */
    public static boolean playPlacedBuilding() {
        int randNum = new Random().nextInt(1, 4);

        switch (randNum) {
            case 1:
                placeBuilding1.play(volume);
                return true;
            case 2:
                placeBuilding2.play(volume);
                return true;
            case 3:
                placeBuilding3.play(volume);
                return true;
        }
        return false;
    }


    /**
     * Plays the error sounds when the user tries
     * placing a building somewhere illegal
     */
    public static boolean playPlaceError() {
        int randNum = new Random().nextInt(1, 3);

        switch (randNum) {
            case 1:
                placeError1.play(volume);
                return true;
            case 2:
                placeError2.play(volume);
                return true;
        }
        return false;
    }

    /**
     * Gets the volume
     *
     * @return Float Volume level
     */
    public static float getVolume() {
        return volume;
    }

    /**
     * Sets the volume level
     *
     * @param volume New volume level
     */
    public static void setVolume(float volume) {
        GameSounds.volume = volume;
    }
}
