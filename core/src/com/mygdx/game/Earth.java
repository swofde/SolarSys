package com.mygdx.game;

public class Earth extends Body {
    private Body father;
    private float distanceFromFather;
    public Earth(float radius, com.badlogic.gdx.graphics.Color color,Body father, float distFromFather, float angle)
    {
        setRadius(radius);
        this.father=father;
        setDistFromFather(distFromFather);
        setColor(color);
        InitOrChangePos(angle);
    }

    public void setDistFromFather(float distanceFromFather) {
        this.distanceFromFather = distanceFromFather;
    }

    public float getDistFromFather() {
        return distanceFromFather;
    }

    public void InitOrChangePos(float angle) {
        float var = getDistFromFather();
        getCoord().setX((float) ( this.father.getCoord().getX()+(Math.sqrt(var*var/2)*Math.cos(angle))));
        getCoord().setY((float) ( this.father.getCoord().getY()+(Math.sqrt(var*var/2)*Math.sin(angle))));
        getCoord().setZ(this.father.getCoord().getZ());
        getCoord().setAngle(angle);
    }

    public Body getFather() {
        return father;
    }

    public void setFather(Body father) {
        this.father = father;
    }
}
