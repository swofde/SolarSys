package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.awt.Point;

public class Body {
    private float radius; //body radius
    private Body father;
    private float distFromFather;
    private Color color;
    private Point3D coord=new Point3D(0,0,0,0);
    Model model;
    ModelInstance modelInstance;
    public Body(float radius, Body father, float distFromFather, Color color, Point3D coord){
        this.radius=radius;
        this.father=father;
        this.distFromFather=distFromFather;
        this.color=color;
        this.coord=coord;
    }




    public void setModel(Model model) {
        this.model = model;
    }

    public void setModelInstance(ModelInstance modelInstance) {
        this.modelInstance = modelInstance;
    }

    public Model getModel() {
        return model;
    }

    public ModelInstance getModelInstance() {
        return modelInstance;
    }

    public Body(){};
    public float getRadius() {
        return radius;
    }

    public Point3D getCoord() {
        return coord;
    }

    public void setCoord(Point3D coord, float angle) {
        Point3D p3d=getFather().getCoord();
        this.coord.setX((float) ( coord.getX()+(Math.sqrt(getDistFromFather()*getDistFromFather()/2)*Math.cos(angle))));
        this.coord.setY((float) ( coord.getY()+(Math.sqrt(getDistFromFather()*getDistFromFather()/2)*Math.sin(angle))));
        this.coord.setZ(p3d.getZ());
        this.coord.setAngle(angle);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFather(Body father) {
        this.father = father;
    }

    public Color getColor() {
        return color;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setDistFromFather(float distFromFather) {
        this.distFromFather = distFromFather;
    }

    public float getDistFromFather() {
        return distFromFather;
    }

    public Body getFather() {
        return father;
    }
    public void dispose()
    {
        this.model.dispose();
    }
}
