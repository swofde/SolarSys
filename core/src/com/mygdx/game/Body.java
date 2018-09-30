package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.awt.Point;

public class Body {
    private float radius; //body radius
    private Color color;
    private Point3D coord=new Point3D(0,0,0,0);
    Model model;
    ModelInstance modelInstance;
    public Body(float radius, Body father, Color color, Point3D coord){
        this.radius=radius;
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



    public void setColor(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }




    public void dispose()
    {
        this.model.dispose();
    }
}
