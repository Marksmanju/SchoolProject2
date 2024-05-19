package org.example;

import org.example.objects.*;
import org.example.objects.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    int FPS = 60;
    public Player player;

    public Point point,point2;
    private Random random = new Random();
    public Enemy enemy;
    public GameButton button;
    public Game game;
    public int pattern;
    public int points;
    private int pointX = random.nextInt(5);
    private int pointY = random.nextInt(5);

    private int point2X = random.nextInt(5);
    private int point2Y = random.nextInt(5);
    public int gameLevel;
    private String url;

    //private KeyManager keyManager;

    //public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed;
    //public boolean size;


    public GameLogic(Game game) {
        //player = new Player(10, 10);
        this.game = game;

        this.gameLevel = 0;

        this.button = new GameButton(500,100,"yellow.png","none");
        this.player = null;
        this.point = null;
        this.enemy = null;
        //keyManager = new KeyManager();

    }

    public void initialize(){
        url = "boy_down_1.png";
        enemy = new Enemy(800,100,"boy_down_2.png");

        player = new Player(0, 0, url);

        button = new GameButton(650,250,"yellow.png","attack2");

        gameLevel = 1;

        pointInitiliaze();

        System.out.println("Game is initilized");


    }


    public void update(){

        if(game.upPressed){
            player.direction = "up";
        }
        else if(game.downPressed){
            player.direction = "down";
            //player.getCoord().y += 3 ;// Update y-coordinate for moving down
        }
        else if(game.leftPressed){
            player.direction = "left";
            //player.getCoord().x -= 3; // Update x-coordinate for moving left
        }
        else if(game.rightPressed){
            player.direction = "right";
            //player.getCoord().x += 3; // Update x-coordinate for moving right
        }


        if(point.isCollided(player.getRectangle())){
            do {
                do {
                    pointX = random.nextInt(5);
                    pointY = random.nextInt(5);
                    point2X = random.nextInt(5);
                    point2Y = random.nextInt(5);
                } while (pointX == player.getX() && pointY == player.getY());
            }while(pointX == point2X && pointY == point2Y);
            point = new Point(128 * pointX, 128 * pointY, "boy_up_1.png");
            point2 = new Point(128 * point2X, 128 * point2Y, "boy_left_2.png");

            points += 100;
            pattern = makePattern();
        }
        if(point2.isCollided(player.getRectangle())){
            do {
                do {
                    pointX = random.nextInt(5);
                    pointY = random.nextInt(5);
                    point2X = random.nextInt(5);
                    point2Y = random.nextInt(5);
                } while (point2X == player.getX() && point2Y == player.getY());
            }while(pointX == point2X && pointY == point2Y);
            point2 = new Point(128 * point2X, 128 * point2Y, "boy_left_2.png");
            point = new Point(128 * pointX, 128 * pointY, "boy_up_1.png");

            points += 100;
            pattern = makePattern();
        }
        switch (gameLevel){
            case 1 -> {enemy.setMaxHp(50);}
            case 2 -> enemy.setMaxHp(100);
            case 3 -> enemy.setMaxHp(150);
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

    public int makePattern() {
        Random random = new Random();
        return random.nextInt(17) + 1;
    }

    public void setTileListTypes(ArrayList<Tile> tileList, String[] types) {
        for (int i = 0; i < tileList.size(); i++) {
            tileList.get(i).updateType(types[i]);
        }
    }

    public String getTileListTypes(ArrayList<ArrayList<Tile>> tileLists){
        String type = null;
        for (ArrayList<Tile> tileList: tileLists)
            for (Tile tile : tileList) {
                if (tile.isCollided(player.getRectangle())) {
                    //System.out.println(tile.getType() + " " + tile.getX() + " " + tile.getY());
                    type = tile.getType();
                }
            }
        return type;
    }

    public void pointInitiliaze(){
        do{
            do {
                pointX = random.nextInt(5);
                pointY = random.nextInt(5);
            } while (pointX == player.getX() && pointY == player.getY());
            do {
                point2X = random.nextInt(5);
                point2Y = random.nextInt(5);
            } while (point2X == player.getX() && point2Y == player.getY());
        }while(pointX == point2X && pointY == point2Y);
        point = new Point(128 * pointX, 128 * pointY, "boy_up_1.png");
        point2 = new Point(128 * point2X, 128 * point2Y, "boy_left_2.png");
    }
    public void movePlayer(String direction, int steps){
        switch (direction){
            case "up" -> {
                if(!((player.getY() - 96) < 0)){
                    player.setY(player.getY() - steps);
                }
            }
            case "left" -> {
                if(!((player.getX() - 96) < 0)){
                    player.setX(player.getX() - steps);
                }
            }
            case "right" -> {
                if(!((player.getX() + 96) > 512)){
                    player.setX(player.getX() + steps);
                }
            }
            case "down" -> {
                if(!((player.getY() + 96) > 512)){
                    player.setY(player.getY() + steps);
                }
            }
        }
    }
}
