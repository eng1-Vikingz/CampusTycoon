package com.vikingz.campustycoon.headless.UI.Components;
import org.junit.jupiter.api.Test;

import com.vikingz.campustycoon.UI.Components.Button;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.Action;



public class ButtonTest {


    @Test
    void testConstructors(){
        Button button = new Button(0,0,0,0);
        assertNotNull(button);

        Button button2 = new Button("imagePath",0,0,0,0);
        assertNotNull(button2);

        Button button3 = new Button("defaultImagePath",0,0,0,0);
        assertNotNull(button3);

        Button button4 = new Button(new ArrayList<>(),0,0,0,0);
        assertNotNull(button4);
    }

    @Test
    void testSetClickAction(){

        Button button = new Button(0,0,0,0);

        button.setClickAction("defualt");
    }

    @Test
    void testToggleBtnFuncs(){

        


    }


}