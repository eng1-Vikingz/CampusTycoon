package com.vikingz.headless.UI.Components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.vikingz.UI.Components.BankruptMenu;
import com.vikingz.headless.HeadlessLauncher;

public class BankruptMenuTest {
    

    @Test
    void testCreateBankruptMenu(){

        HeadlessLauncher.main(new String[0]);

        assertTrue(Gdx.files.internal("glassy-ui/skin/glassy-ui.json").exists());

        
        Skin skin = new Skin(Gdx.files.internal("glassy-ui/skin/glassy-ui.json"));
        BankruptMenu bankruptMenu = new BankruptMenu(skin);

    }

    
}
