package com.vikingz.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.ArrayList;
import java.util.Random;

public class GameMusic {

    //Object that holds backgroundMusic to be played
    private static Music backgroundMusic;

    //Sets the volume of the background music
    public static float volume = 1f;

    /**
     * Initialises the Game music class by loading in the
     * sound files and settings initial settings
     */
    public GameMusic() {
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/Background_Music.ogg"));
        backgroundMusic.setLooping(true);
    }

    /**
     * Plays the game music
     */
    public static void play(){
        backgroundMusic.setVolume(volume);
        backgroundMusic.play();
    }

    /**
     * Gets the volume of the music
     * @return Float Volume level
     */
    public static float getVolume() {
        return volume;
    }

    /**
     * Sets the volume of the music
     * @param volume New volume level
     */
    public static void setVolume(float volume) {
        GameMusic.volume = volume;
        play();
    }

}


