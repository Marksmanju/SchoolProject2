package org.example.objects;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private int width;
    private int height;
    private Image image;
    private int x;
    private int y;
    private String type;

    public Tile(int x, int y, String url) {
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url));
        this.image = ii.getImage();

        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(String type) {
        this.type = type;
    }
}
