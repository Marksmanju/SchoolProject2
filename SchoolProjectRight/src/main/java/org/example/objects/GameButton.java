package org.example.objects;

public class GameButton extends GameObject {
    private String type;
    public GameButton(int x, int y, String url, String type) {
        super(x,y,url);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
