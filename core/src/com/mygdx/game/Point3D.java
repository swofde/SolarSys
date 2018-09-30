package com.mygdx.game;

public class Point3D {
    private float x;
    private float y;
    private float z;
    private float angle;
    public Point3D(float x, float y, float z, float angle)
    {
        this.x=x;
        this.y=y;
        this.z=z;
        this.angle=angle;
    };

    public float getX() {
        return x;
    }

    public float getAngle() {
        return angle;
    }


    public void setAngle(float angle) {
        if(angle>360)
            this.angle =angle-360;
        else
            this.angle=angle;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
