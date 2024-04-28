package org.example;

import org.example.objects.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GameLogic {
    int FPS = 60;
    public Player player;

    private Game game;

    //private KeyManager keyManager;

    //public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed;
    //public boolean size;


    public GameLogic(Game game) {
        //player = new Player(10, 10);
        this.game = game;

        this.player = null;
        //keyManager = new KeyManager();
    }

    public void initialize(){
        player = new Player(10, 10, Color.CYAN);
        System.out.println("Game is initilized");
    }


    public void update(){

        if(game.upPressed){
            player.direction = "up";
            player.getCoord().y -= 3; // Update y-coordinate for moving up
        }
        else if(game.downPressed){
            player.direction = "down";
            player.getCoord().y += 3 ;// Update y-coordinate for moving down
        }
        else if(game.leftPressed){
            player.direction = "left";
            player.getCoord().x -= 3; // Update x-coordinate for moving left
        }
        else if(game.rightPressed){
            player.direction = "right";
            player.getCoord().x += 3; // Update x-coordinate for moving right
        }




    }
    public void getPlayerImage(){
        try
        {
            // if a problem appears that means that you put it in a wrong directory, this video should solve this issue, https://www.youtube.com/watch?v=Q9jtg0ocGgo
            player.up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            player.up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            player.down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            player.down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            player.left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            player.left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            player.right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            player.right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        }
        catch (IOException e){ // this is for throwing an error if an image doesnt exist
            e.printStackTrace();
        }
    }



    public Player getPlayer() {
        return player;
    }
}
