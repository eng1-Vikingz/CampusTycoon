package com.vikingz.campustycoon.headless;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class HeadlessSpriteBatch extends SpriteBatch {

    public HeadlessSpriteBatch() {
        super();
    }

    public static ShaderProgram createDefaultShader() {
        return new ShaderProgram("", ""); // Provide empty vertex and fragment shaders
    }
}
