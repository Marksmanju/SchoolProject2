package org.example.objects;

public class Enemy extends GameObject{
    private int hp;
    private int maxHp;
    public Enemy(int x, int y,String url, String url2) {
        super(x,y,url,url2);
        maxHp = 50;
        hp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int hp) {
        this.maxHp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
