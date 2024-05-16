package org.example;

import org.example.objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game extends Thread{
    Thread gameThread;
    public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed;
    public boolean size;

    private GameLogic logic;
    public GameGraphics graphics;
    private long lastPatternUpdateTime = System.nanoTime();

    public boolean second;
    //private Player player;
    //Player player = new Player(10,10);

    //KeyManager keyManager = new KeyManager();

    int FPS = 60;

    public Game() {
        logic = new GameLogic(this);
        graphics = new GameGraphics(logic);
        logic.initialize(); // Initilazies all the logic code in logic initiliaze
        graphics.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                int steps = 128;
                if((code == KeyEvent.VK_W) || (code == KeyEvent.VK_UP)){
                    upPressed = true;
                    logic.player.setColor(Color.red);
                    if(!((logic.player.getY() - 96) < 0)){
                        logic.player.setY(logic.player.getY() - steps);
                    }
                    //logic.player.direction = "up";
                    //logic.player.getCoord().y -= 10; // Update y-coordinate for moving up
                }
                if((code == KeyEvent.VK_S) || (code == KeyEvent.VK_DOWN)){
                    downPressed = true;
                    logic.player.setColor(Color.blue);
                    if(!((logic.player.getY() + 96) > 512)){
                        logic.player.setY(logic.player.getY() + steps);
                    }
                    //logic.player.direction = "down";
                    //logic.player.getCoord().y += 10; // Update y-coordinate for moving up
                }
                if((code == KeyEvent.VK_A) || (code == KeyEvent.VK_LEFT)){
                    leftPressed = true;
                    logic.player.setColor(Color.yellow);
                    if(!((logic.player.getX() - 96) < 0)){
                        logic.player.setX(logic.player.getX() - steps);
                    }
                    //logic.player.direction = "left";
                    //logic.player.getCoord().x -= 10; // Update y-coordinate for moving up
                }
                if((code == KeyEvent.VK_D) || (code == KeyEvent.VK_RIGHT)){
                    rightPressed = true;
                    logic.player.setColor(Color.GREEN);
                    if(!((logic.player.getX() + 96) > 512)){
                        logic.player.setX(logic.player.getX() + steps);
                    }
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
        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                if (second) {
                    //int pattern = logic.makePattern(); // Update the pattern
                    second = false;
                    lastPatternUpdateTime = currentTime; // Update the last update time
                }
                long elapsedTimeSincePatternUpdate = currentTime - lastPatternUpdateTime;
                if (elapsedTimeSincePatternUpdate >= 1_000_000_000) { // Check if one second has passed
                    second = true; // Set second to true to trigger the pattern update on the next iteration
                }

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
            Game game = new Game(); // starts the game Thread ie. starts the game loop
            game.startGameThread();
        });
    }

}