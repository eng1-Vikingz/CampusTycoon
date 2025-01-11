package com.vikingz.campustycoon.headless.Util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.vikingz.campustycoon.Util.GameMusic;
import com.vikingz.campustycoon.Util.GameSounds;
import com.vikingz.campustycoon.headless.HeadlessLauncher;

public class GameSoundsTest {


    @BeforeEach
    void setUpHeadless(){

        HeadlessLauncher.main(new String[0]);
        Gdx.audio = org.mockito.Mockito.mock(com.badlogic.gdx.Audio.class);
        Sound mockSound = org.mockito.Mockito.mock(Sound.class);
        org.mockito.Mockito.when(Gdx.audio.newSound(org.mockito.ArgumentMatchers.any())).thenReturn(mockSound);

    }

    @Test
    void testPlayPlacedBuilding(){
        assertTrue(GameSounds.playPlacedBuilding());

    }

    @Test
    void testPlayPlaceError(){
        assertTrue(GameSounds.playPlaceError());
    }

    @Test
    void testVolume(){
        GameSounds.setVolume(0.5f);
        assertTrue(GameSounds.getVolume() == 0.5f);
    }

    @Test
    void testGameMusicVolume(){
        GameMusic.setVolume(0.5f);
        assertTrue(GameMusic.getVolume() == 0.5f);
    }

}
