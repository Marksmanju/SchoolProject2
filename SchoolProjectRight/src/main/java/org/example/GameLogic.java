package org.example;

import org.example.objects.*;
import org.example.objects.Point;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    public int totalTime;
    int FPS = 60;
    public Player player;

    public Point point,point2;
    private Random random = new Random();
    public Enemy enemy;
    public GameButton button,button2,button3,menuButton1,menuButton2,buttonGameOver;
    public Game game;
    public int pattern;
    public int pointsRed,pointsBlue;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    private int pointX = random.nextInt(5);
    private int pointY = random.nextInt(5);

    private int point2X = random.nextInt(5);
    private int point2Y = random.nextInt(5);
    public int gameLevel;
    public double gameTimer;
    public String url,url2;

    public GameLogic(Game game) {
        //player = new Player(10, 10);
        this.game = game;

        this.gameLevel = 0;

        this.button = null;
        this.player = null;
        this.point = null;
        this.enemy = null;

        this.totalTime = 240;
        //keyManager = new KeyManager();
    }
    public void initialize(){
        url = "player_1_right.png";
        url2 = "player_2_right.png";

        enemy = new Enemy(850,100,"boy_down_2.png","boy_down_1.png");

        player = new Player(256, 256, url, url2);

        gameTimer = 120;

        button = new GameButton(640,256,"white.png","-2 HP");
        button2 = new GameButton(640,384,"white.png","-1 HP + 5 TIME");
        button3 = new GameButton(640,512,"white.png","+10 time");

        menuButton1 = new GameButton(100,250,"white.png","PLAY");
        menuButton2 = new GameButton(100,450,"white.png","EXIT");

        buttonGameOver = new GameButton(400,450,"white.png","GAMEOVER");

        gameLevel = 0;

        pointInitiliaze();

        System.out.println("Game is initilized");
    }

    public void update(){
        if(player.direction == "left"){
            url = "player_1_left.png";
            url2 = "player_2_left.png";
            player = new Player(player.getX(), player.getY(), url, url2);
        }
        else if (player.direction == "right"){
            url = "player_1_right.png";
            url2 = "player_2_right.png";
            player = new Player(player.getX(), player.getY(), url, url2);
        }
        if(totalTime <= 0){
            gameLevel = -1;
        }
        if(enemy.getHp() == 0){
            gameLevel += 1;
            enemy.setHp(50*gameLevel);
            totalTime = 240;
            pointsRed = 0;
            pointsBlue = 0;
        }
        spriteCounter++;
        if (spriteCounter > 10) //frames to update the sprite, sprite updates every x frames
        {
            if (spriteNum == 1)
            {
                spriteNum = 2;
            }
            else if (spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
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
            point = new Point(128 * pointX, 128 * pointY, "red_point.png","red_point_2.png");
            point2 = new Point(128 * point2X, 128 * point2Y, "blue_point.png","blue_point_2.png");

            pointsRed += 100;
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
            point = new Point(128 * pointX, 128 * pointY, "red_point.png","red_point_2.png");
            point2 = new Point(128 * point2X, 128 * point2Y, "blue_point.png","blue_point_2.png");

            pointsBlue += 100;
            pattern = makePattern();
        }
        switch (gameLevel){
            case 1 -> {enemy.setMaxHp(50);}
            case 2 -> enemy.setMaxHp(100);
            case 3 -> enemy.setMaxHp(150);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int makePattern() {
        Random random = new Random();
        return random.nextInt(18) + 1;
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
        point = new Point(128 * pointX, 128 * pointY, "red_point.png","red_point_2.png");
        point2 = new Point(128 * point2X, 128 * point2Y, "blue_point.png","blue_point_2.png");
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
    public String getFormattedTime() {
        int minutes = totalTime / 60;
        int seconds = totalTime % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
    public void getButtonInfo(GameButton button,int mouseX, int mouseY){
        int buttonX = button.getX();
        int buttonY = button.getY();

        int buttonWidth = game.graphics.tileSize*2; // Assuming you have a method to get width
        int buttonHeight = game.graphics.tileSize;
        if(gameLevel != 0) {
            switch (button.getType()) {
                case "-2 HP":
                    if (mouseX >= buttonX && mouseX <= buttonX + buttonWidth && mouseY >= buttonY && mouseY <= buttonY + buttonHeight) {
                        if (pointsRed >= 100) {
                            enemy.setHp(enemy.getHp() - 2);
                            pointsRed -= 100;
                        }
                    }
                    break;
                case "-1 HP + 5 TIME":
                    if (mouseX >= buttonX && mouseX <= buttonX + buttonWidth && mouseY >= buttonY && mouseY <= buttonY + buttonHeight) {
                        if (pointsBlue >= 100) {
                            enemy.setHp(enemy.getHp() - 2);
                            pointsBlue -= 100;
                        }
                    }
                    break;
                case "+10 time":
                    if (mouseX >= buttonX && mouseX <= buttonX + buttonWidth && mouseY >= buttonY && mouseY <= buttonY + buttonHeight) {
                        if (pointsRed >= 50 && pointsBlue >= 50) {
                            totalTime += 10;
                            pointsRed -= 50;
                            pointsBlue -= 50;

                        }
                    }
                    break;
                default:
                    // Default case
                    break;
            }
        }
    }
    public void getButtonMenuInfo(GameButton button,int mouseX, int mouseY){
        int buttonX = button.getX();
        int buttonY = button.getY();

        int buttonWidth = game.graphics.tileSize*2; // Assuming you have a method to get width
        int buttonHeight = game.graphics.tileSize;
        switch (button.getType()) {
            case "PLAY":
                if (mouseX >= buttonX && mouseX <= buttonX + buttonWidth && mouseY >= buttonY && mouseY <= buttonY + buttonHeight) {
                    System.out.println("AFASFASFASFAFASFASF");
                    initialize();
                    pointsBlue = 0;
                    pointsRed = 0;

                    gameLevel += 1;
                }
                break;
            case "EXIT":
                if (mouseX >= buttonX && mouseX <= buttonX + buttonWidth && mouseY >= buttonY && mouseY <= buttonY + buttonHeight) {
                    System.exit(0);
                }
                break;
            case "GAMEOVER":
                if (mouseX >= buttonX && mouseX <= buttonX + game.graphics.tileSize*3 && mouseY >= buttonY && mouseY <= buttonY + buttonHeight) {
                    gameLevel = 0;
                    totalTime = 240;
                }
                break;
            default:
                // Default case
                break;
        }
    }

}
