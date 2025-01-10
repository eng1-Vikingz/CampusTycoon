package com.vikingz.campustycoon.headless.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.UI.Camera;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.Util.GameUtils;
import com.vikingz.campustycoon.headless.HeadlessLauncher;


public class GameUtilsTest {


    @BeforeEach
    void setUpHeadless(){
        new HeadlessLauncher();
        HeadlessLauncher.main(new String[0]);

        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;

        // Mock the graphics class.
        Gdx.graphics = Mockito.mock(Graphics.class);
        when(Gdx.graphics.getWidth()).thenReturn(1000);
        when(Gdx.graphics.getHeight()).thenReturn(1000);
        
        SpriteBatch batch = mock(SpriteBatch.class);
    }



    @Test
    public void testGetHoverImagePath() {
        String originalImage = "test.png";
        String expectedHoverImage = "testTransparent.png";
        assertEquals(expectedHoverImage, GameUtils.getHoverImagePath(originalImage));

        originalImage = "";
        expectedHoverImage = "MissingTexture.png";
        assertEquals(expectedHoverImage, GameUtils.getHoverImagePath(originalImage));
    }
    



}

