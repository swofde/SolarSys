package com.mygdx.game;

import java.awt.Color;

public class Sun extends Body {

    public Sun(float radius, com.badlogic.gdx.graphics.Color color)
    {
        setRadius(radius);
        setColor(color);
        setCoord();
    }
    private void setCoord() {
        getCoord().setX(0f);
        getCoord().setY(0f);
        getCoord().setZ(0f);
        getCoord().setAngle(0);
    }
}
