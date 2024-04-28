package org.example.objects;

import org.example.GameGraphics;

import java.awt.image.BufferedImage;

public class GameObject {
    protected Coordinates coord;
    protected int height;
    protected int width;
    public GameObject(int x, int y){
        this.coord = new Coordinates(x,y);
        this.height = height;
        this.width = width;

    }
    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }
    public int getX() {
        return coord.x;
    }

    public void setX(int x) {
        this.coord.x = x;
    }

    public int getY() {
        return coord.y;
    }

    public void setY(int y) {
        this.coord.y = y;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }



}
