package com.vikingz.campustycoon.headless.UI.Systems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.UI.Systems.MapDisplay;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.headless.HeadlessLauncher;

public class MapDisplayTest {
    

    @BeforeEach
    void setUp() {
        // Launch the game in headless mode
        new HeadlessLauncher();
        HeadlessLauncher.main(new String[0]);
    
        // Mock Graphics
        Gdx.graphics = Mockito.mock(Graphics.class);
    
        // Mock GL20
        GL20 gl20 = Mockito.mock(GL20.class);
        Gdx.gl = gl20;
    
        // Mock necessary GL20 methods
        Mockito.when(gl20.glCreateShader(Mockito.anyInt())).thenReturn(1); // Mock shader creation
        Mockito.when(gl20.glCreateProgram()).thenReturn(1); // Mock program creation
        Mockito.doNothing().when(gl20).glShaderSource(Mockito.anyInt(), Mockito.anyString()); // Mock shader source
        Mockito.doNothing().when(gl20).glCompileShader(Mockito.anyInt()); // Mock shader compilation
        Mockito.doNothing().when(gl20).glAttachShader(Mockito.anyInt(), Mockito.anyInt()); // Mock attaching shader
        Mockito.doNothing().when(gl20).glLinkProgram(Mockito.anyInt()); // Mock program linking
    
        ShaderProgram mockedShaderProgram = Mockito.mock(ShaderProgram.class);
        Mockito.when(SpriteBatch.createDefaultShader()).thenReturn(mockedShaderProgram);
        // Mock SpriteBatch
        Drawer.spriteBatch = Mockito.mock(SpriteBatch.class);
    }


    @Test
    void testCreateMapDisplay(){

        Map map = new Map();
        MapDisplay md = new MapDisplay(map);   
    }

}
