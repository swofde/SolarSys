package com.mygdx.game;

public class Earth extends Body {
    public Earth(float radius, com.badlogic.gdx.graphics.Color color,Body father, float distFromFather, float angle)
    {
        setRadius(radius);
        setFather(father);
        setDistFromFather(distFromFather);
        setColor(color);
        setCoord(father.getCoord(),angle);
    }
}
