package com.vikingz.campustycoon.headless.Game.Maps;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.vikingz.campustycoon.Game.Maps.Map;
import com.vikingz.campustycoon.Game.Maps.York;
import com.vikingz.campustycoon.headless.HeadlessLauncher;

public class MapTest {
    
    @BeforeEach
    void setUpHeadless(){

        // This runs the game before each test in headless mode !

        new HeadlessLauncher();
        HeadlessLauncher.main(new String[0]);

        GL20 gl20 = Mockito.mock(GL20.class);
        Gdx.gl = gl20;
        Gdx.gl20 = gl20;
        
        Gdx.graphics = Mockito.mock(com.badlogic.gdx.Graphics.class);


    }

    @Test
    void testConstructor(){


    }

    @Test
    void testYorkMapExists(){
        York york = new York();
        assertNotNull(york);
    }

}
