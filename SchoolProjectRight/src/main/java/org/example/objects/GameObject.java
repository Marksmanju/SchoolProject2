package org.example.objects;

import org.example.GameGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    protected Coordinates coord;
    protected int height,height2;
    protected int width,width2;
    protected Image image,image2;
    public GameObject(int x, int y, String url){
        this.coord = new Coordinates(x,y);
        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url));
        this.image = ii.getImage();

        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
    }
    public GameObject(int x, int y, String url, String url2){
        this.coord = new Coordinates(x,y);
        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url));
        ImageIcon ii2 = new ImageIcon(getClass().getResource("/" + url2));
        this.image = ii.getImage();
        this.image2 = ii2.getImage();

        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
        this.width2 = ii2.getIconWidth();
        this.height2 = ii2.getIconHeight();
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Rectangle getRectangle(){
        return new Rectangle(coord.x,coord.y,width, height);
    }

    public boolean isCollided (Rectangle otherObject) {
        return getRectangle().intersects(otherObject);
    }

    public int getHeight2() {
        return height2;
    }

    public void setHeight2(int height2) {
        this.height2 = height2;
    }

    public int getWidth2() {
        return width2;
    }

    public void setWidth2(int width2) {
        this.width2 = width2;
    }

    public Image getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }
}
