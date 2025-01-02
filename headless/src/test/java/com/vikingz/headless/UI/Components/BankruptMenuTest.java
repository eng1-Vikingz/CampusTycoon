package com.vikingz.headless.UI.Components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.vikingz.UI.Components.BankruptMenu;
import com.vikingz.headless.HeadlessLauncher;

public class BankruptMenuTest {
    

    @BeforeEach
    void setUp(){

        // This runs the game before each test in headless mode !

        new HeadlessLauncher();
        HeadlessLauncher.main(new String[0]);

        GL20 gl20 = Mockito.mock(GL20.class);
        Gdx.gl = gl20;
        Gdx.graphics = Mockito.mock(com.badlogic.gdx.Graphics.class);

    }



    @Test
    void testCreateBankruptMenu(){

        assertTrue(Gdx.files.internal("glassy-ui/skin/glassy-ui.json").exists());
        
        Skin skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));
        BankruptMenu bankruptMenu = new BankruptMenu(skin);

        // Testing button pressing 
        bankruptMenu.clickQuit();

    }

    
}
