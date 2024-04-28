package org.example;

import org.example.objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game extends Thread{
    Thread gameThread;
    public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed;
    public boolean size;

    private GameLogic logic;
    private GameGraphics graphics;
    //private Player player;
    //Player player = new Player(10,10);

    //KeyManager keyManager = new KeyManager();




    int FPS = 60;

    public Game() {
        logic = new GameLogic(this);
        graphics = new GameGraphics(logic);
        logic.initialize();
        graphics.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();

                if((code == KeyEvent.VK_W) || (code == KeyEvent.VK_UP)){
                    upPressed = true;
                    logic.player.setColor(Color.red);
                    //logic.player.direction = "up";
                    //logic.player.getCoord().y -= 10; // Update y-coordinate for moving up
                }
                if((code == KeyEvent.VK_S) || (code == KeyEvent.VK_DOWN)){
                    downPressed = true;
                    logic.player.setColor(Color.blue);
                    //logic.player.direction = "down";
                    //logic.player.getCoord().y += 10; // Update y-coordinate for moving up
                }
                if((code == KeyEvent.VK_A) || (code == KeyEvent.VK_LEFT)){
                    leftPressed = true;
                    logic.player.setColor(Color.yellow);
                    //logic.player.direction = "left";
                    //logic.player.getCoord().x -= 10; // Update y-coordinate for moving up
                }
                if((code == KeyEvent.VK_D) || (code == KeyEvent.VK_RIGHT)){
                    rightPressed = true;
                    logic.player.setColor(Color.GREEN);
                    //logic.player.direction = "right";
                    //logic.player.getCoord().x += 10; // Update y-coordinate for moving up
                }
                if(code == KeyEvent.VK_E){
                    size = !size;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                if((code == KeyEvent.VK_W) || (code == KeyEvent.VK_UP)){
                    upPressed = false;
                }
                if((code == KeyEvent.VK_S) || (code == KeyEvent.VK_DOWN)){
                    downPressed = false;
                }
                if((code == KeyEvent.VK_A) || (code == KeyEvent.VK_LEFT)){
                    leftPressed = false;
                }
                if((code == KeyEvent.VK_D) || (code == KeyEvent.VK_RIGHT)){
                    rightPressed = false;
                }


            }
        });


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
                graphics.render(logic);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.startGameThread();
        });
    }

}