package com.vikingz.campustycoon.headless.Util;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.vikingz.campustycoon.UI.Components.Button;
import com.vikingz.campustycoon.UI.Components.Component;
import com.vikingz.campustycoon.Util.Drawer;
import com.vikingz.campustycoon.headless.HeadlessLauncher;


public class DrawerTest {

    @BeforeEach
    void setUp(){
        HeadlessLauncher.main(new String[0]);
        Gdx.gl = mock(GL20.class);
        Gdx.gl20 = Gdx.gl;
    }

    @Test
    void testDrawInfo(){
        Button btn = new Button(0, 0, 0, 0);
        Button btn1 = new Button(5, 4, 0, 0);
        Drawer.DrawInfo info = new Drawer.DrawInfo(1, (Component) btn);
        Drawer.DrawInfo info2 = new Drawer.DrawInfo(3, (Component) btn1);

        assertEquals(1, info.layer);
        assertEquals(btn, info.component);



    }



}
