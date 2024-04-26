package org.example;

import org.example.objects.Player;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game extends Thread{
    Thread gameThread;
    GameLogic logic = new GameLogic();
    GameGraphics graphics = new GameGraphics(logic);
    Player player = new Player(10,10);

    KeyManager keyManager = new KeyManager();




    int FPS = 60;

    public Game() {
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run(){
        //startGameThread();
        double drawInterval = 1000000000/FPS;// returns the current value of the running java virtual machines high resolution time source in nanoseconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while(gameThread != null) { // this is for setting the FPS and such its kinda complicated so dont play with this too much

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >=1) {
                logic.update();
                graphics.repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("game loop is funcntional"); // debug message to check if game loop works
                System.out.println("FPS: " + drawCount);
                System.out.println("Player Position: " + logic.getPlayer().getCoord().x +" and "+ logic.getPlayer().getCoord().y + " direction " + logic.getPlayer().getDirection());
                drawCount = 0;
                timer = 0;
            }
        }
    }


}