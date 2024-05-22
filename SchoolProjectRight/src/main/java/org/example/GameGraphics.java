package org.example;

import org.example.objects.GameButton;
import org.example.objects.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

public class GameGraphics extends JFrame{
    private final int width;
    private final int height;
    private final Image imageLogo;
    private final Image imageGameover;
    public Draw draw;
    private Font font;
    GameLogic logic;
    final int ogTileSize = 32; //original tile size
    final int scale = 4; // scale of the sprites
    public final int tileSize = ogTileSize * scale; // size of individual tiles
    final int maxScrCol = 9; // maximum screen column og 8
    final int maxScrRow = 6; // maximum screen row

    public final int scrWidth = tileSize * maxScrCol; // screen width,
    public final int scrHeight = tileSize * maxScrRow; // screen height,
    public Button button;



    //KeyManager keyManager= new KeyManager();
    public GameGraphics(GameLogic logic) throws HeadlessException {
        this.draw = new Draw();
        add(draw);
        this.logic = logic;

        setSize(scrWidth, scrHeight);
        setLocationRelativeTo(null); // sets location of the window. Null makes it in the middle of the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setTitle("sfdsd");

        ImageIcon ii = new ImageIcon(getClass().getResource("/" + "project_logo.png"));

        this.imageLogo = ii.getImage();

        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();

        ImageIcon ii2 = new ImageIcon(getClass().getResource("/" + "project_gameover.png"));

        this.imageGameover = ii2.getImage();


    }



    public class Draw extends JPanel {
        //region TILES
        //1 ROW=============================================================
        Tile tile0_0 = new Tile(tileSize*0,tileSize*0,"green");
        Tile tile1_0 = new Tile(tileSize*1,tileSize*0,"green");
        Tile tile2_0 = new Tile(tileSize*2,tileSize*0,"green");
        Tile tile3_0 = new Tile(tileSize*3,tileSize*0,"green");
        Tile tile4_0 = new Tile(tileSize*4,tileSize*0,"green");
        //2 ROW=============================================================
        Tile tile0_1 = new Tile(tileSize*0,tileSize*1,"green");
        Tile tile1_1 = new Tile(tileSize*1,tileSize*1,"green");
        Tile tile2_1 = new Tile(tileSize*2,tileSize*1,"green");
        Tile tile3_1 = new Tile(tileSize*3,tileSize*1,"green");
        Tile tile4_1 = new Tile(tileSize*4,tileSize*1,"green");
        //3 ROW=============================================================
        Tile tile0_2 = new Tile(tileSize*0,tileSize*2,"green");
        Tile tile1_2 = new Tile(tileSize*1,tileSize*2,"green");
        Tile tile2_2 = new Tile(tileSize*2,tileSize*2,"green");
        Tile tile3_2 = new Tile(tileSize*3,tileSize*2,"green");
        Tile tile4_2 = new Tile(tileSize*4,tileSize*2,"green");
        //4 ROW=============================================================
        Tile tile0_3 = new Tile(tileSize*0,tileSize*3,"green");
        Tile tile1_3 = new Tile(tileSize*1,tileSize*3,"green");
        Tile tile2_3 = new Tile(tileSize*2,tileSize*3,"green");
        Tile tile3_3 = new Tile(tileSize*3,tileSize*3,"green");
        Tile tile4_3 = new Tile(tileSize*4,tileSize*3,"green");
        //5 ROW=============================================================
        Tile tile0_4 = new Tile(tileSize*0,tileSize*4,"green");
        Tile tile1_4 = new Tile(tileSize*1,tileSize*4,"green");
        Tile tile2_4 = new Tile(tileSize*2,tileSize*4,"green");
        Tile tile3_4 = new Tile(tileSize*3,tileSize*4,"green");
        Tile tile4_4 = new Tile(tileSize*4,tileSize*4,"green");
        //endregion

        public void paintComponent(Graphics g) { // draws graphics, like the draw event in GMS2
            super.paintComponent(g);
            //region ARRAYLISTS
            ArrayList<Tile> tileList1 = new ArrayList<Tile>(); // ROW 1
            ArrayList<Tile> tileList2 = new ArrayList<Tile>(); // ROW 2
            ArrayList<Tile> tileList3 = new ArrayList<Tile>(); // ROW 3
            ArrayList<Tile> tileList4 = new ArrayList<Tile>(); // ROW 4
            ArrayList<Tile> tileList5 = new ArrayList<Tile>(); // ROW 5
            ArrayList<ArrayList<Tile>> tileLists = new ArrayList<ArrayList<Tile>>();
            ArrayList<GameButton> buttons = new ArrayList<GameButton>();
            ArrayList<GameButton> buttonsMenu = new ArrayList<GameButton>();
            //endregion
            //region FONTS
            Font myFont = new Font("Excluded", Font.PLAIN, 40);
            Font myFont2 = new Font("Excluded", Font.PLAIN, 35);
            Font myFont3 = new Font("Excluded", Font.PLAIN, 17);
            Font myFont4 = new Font("Excluded", Font.PLAIN, 25);
            //endregion
            //region PATTERNS
            String[] typePattern1 =     {"green", "green", "green", "green", "green"};
            String[] typePattern2 =     {"red", "green", "green", "green", "green"};
            String[] typePattern3 =     {"green", "green", "red", "green", "green"};
            String[] typePattern4 =     {"green", "green", "green", "red", "green"};
            String[] typePattern5 =     {"green", "green", "green", "green", "red"};
            String[] typePattern6 =     {"green", "red", "green", "green", "green"};
            String[] typePattern7 =     {"green", "red", "red", "green", "green"};
            String[] typePattern8 =     {"red", "green", "green", "green", "red"};
            String[] typePattern9 =     {"green", "green", "red", "red", "green"};
            String[] typePattern10 =    {"green", "red", "green", "green", "red"};
            //endregion
            //region BUTTON ADDING
            buttons.add(logic.button);
            buttons.add(logic.button2);
            buttons.add(logic.button3);

            buttonsMenu.add(logic.menuButton1);
            buttonsMenu.add(logic.menuButton2);

            //endregion
            //region TILE LIST ADDING
            tileList1.add(tile0_0);
            tileList1.add(tile1_0);
            tileList1.add(tile2_0);
            tileList1.add(tile3_0);
            tileList1.add(tile4_0);

            tileList2.add(tile0_1);
            tileList2.add(tile1_1);
            tileList2.add(tile2_1);
            tileList2.add(tile3_1);
            tileList2.add(tile4_1);

            tileList3.add(tile0_2);
            tileList3.add(tile1_2);
            tileList3.add(tile2_2);
            tileList3.add(tile3_2);
            tileList3.add(tile4_2);

            tileList4.add(tile0_3);
            tileList4.add(tile1_3);
            tileList4.add(tile2_3);
            tileList4.add(tile3_3);
            tileList4.add(tile4_3);

            tileList5.add(tile0_4);
            tileList5.add(tile1_4);
            tileList5.add(tile2_4);
            tileList5.add(tile3_4);
            tileList5.add(tile4_4);

            tileLists.add(tileList1);
            tileLists.add(tileList2);
            tileLists.add(tileList3);
            tileLists.add(tileList4);
            tileLists.add(tileList5);
            //endregion
            Graphics2D g2 = (Graphics2D) g; // Graphics2D class extends the Grapgics class to provide more sophisticated control over geometrz, coordinta transformations, color management, and text layout.

            if(logic.gameLevel > 0) {
                int pattern = logic.pattern;
                setBackground((Color.LIGHT_GRAY)); // background color of the window
                //region PATTERNS
                switch (pattern) {
                    case 1:
                        logic.setTileListTypes(tileList1, typePattern1);
                        logic.setTileListTypes(tileList2, typePattern2);
                        logic.setTileListTypes(tileList3, typePattern3);
                        logic.setTileListTypes(tileList4, typePattern4);
                        logic.setTileListTypes(tileList5, typePattern5);

                        break;
                    case 2:
                        logic.setTileListTypes(tileList1, typePattern2);
                        logic.setTileListTypes(tileList2, typePattern3);
                        logic.setTileListTypes(tileList3, typePattern4);
                        logic.setTileListTypes(tileList4, typePattern1);
                        logic.setTileListTypes(tileList5, typePattern2);
                        break;
                    case 3:
                        logic.setTileListTypes(tileList1, typePattern3);
                        logic.setTileListTypes(tileList2, typePattern4);
                        logic.setTileListTypes(tileList3, typePattern7);
                        logic.setTileListTypes(tileList4, typePattern2);
                        logic.setTileListTypes(tileList5, typePattern3);
                        break;
                    case 4:
                        logic.setTileListTypes(tileList1, typePattern4);
                        logic.setTileListTypes(tileList2, typePattern6);
                        logic.setTileListTypes(tileList3, typePattern2);
                        logic.setTileListTypes(tileList4, typePattern3);
                        logic.setTileListTypes(tileList5, typePattern4);
                        break;
                    case 5:
                        logic.setTileListTypes(tileList1, typePattern7);
                        logic.setTileListTypes(tileList2, typePattern7);
                        logic.setTileListTypes(tileList3, typePattern2);
                        logic.setTileListTypes(tileList4, typePattern1);
                        logic.setTileListTypes(tileList5, typePattern5);
                        break;

                    case 6:
                        logic.setTileListTypes(tileList1, typePattern4);
                        logic.setTileListTypes(tileList2, typePattern7);
                        logic.setTileListTypes(tileList3, typePattern8);
                        logic.setTileListTypes(tileList4, typePattern5);
                        logic.setTileListTypes(tileList5, typePattern2);
                        break;
                    case 7:
                        logic.setTileListTypes(tileList1, typePattern5);
                        logic.setTileListTypes(tileList2, typePattern6);
                        logic.setTileListTypes(tileList3, typePattern7);
                        logic.setTileListTypes(tileList4, typePattern8);
                        logic.setTileListTypes(tileList5, typePattern6);
                        break;
                    case 8:
                        logic.setTileListTypes(tileList1, typePattern6);
                        logic.setTileListTypes(tileList2, typePattern7);
                        logic.setTileListTypes(tileList3, typePattern8);
                        logic.setTileListTypes(tileList4, typePattern9);
                        logic.setTileListTypes(tileList5, typePattern10);
                        break;
                    case 9:
                        logic.setTileListTypes(tileList1, typePattern7);
                        logic.setTileListTypes(tileList2, typePattern8);
                        logic.setTileListTypes(tileList3, typePattern9);
                        logic.setTileListTypes(tileList4, typePattern10);
                        logic.setTileListTypes(tileList5, typePattern1);
                        break;
                    case 10:
                        logic.setTileListTypes(tileList1, typePattern8);
                        logic.setTileListTypes(tileList2, typePattern9);
                        logic.setTileListTypes(tileList3, typePattern10);
                        logic.setTileListTypes(tileList4, typePattern1);
                        logic.setTileListTypes(tileList5, typePattern2);
                        break;
                    case 11:
                        logic.setTileListTypes(tileList1, typePattern9);
                        logic.setTileListTypes(tileList2, typePattern10);
                        logic.setTileListTypes(tileList3, typePattern1);
                        logic.setTileListTypes(tileList4, typePattern2);
                        logic.setTileListTypes(tileList5, typePattern3);
                        break;
                    case 12:
                        logic.setTileListTypes(tileList1, typePattern10);
                        logic.setTileListTypes(tileList2, typePattern1);
                        logic.setTileListTypes(tileList3, typePattern2);
                        logic.setTileListTypes(tileList4, typePattern3);
                        logic.setTileListTypes(tileList5, typePattern4);
                        break;
                    case 13:
                        logic.setTileListTypes(tileList1, typePattern1);
                        logic.setTileListTypes(tileList2, typePattern2);
                        logic.setTileListTypes(tileList3, typePattern3);
                        logic.setTileListTypes(tileList4, typePattern4);
                        logic.setTileListTypes(tileList5, typePattern5);
                        break;
                    case 14:
                        logic.setTileListTypes(tileList1, typePattern2);
                        logic.setTileListTypes(tileList2, typePattern3);
                        logic.setTileListTypes(tileList3, typePattern4);
                        logic.setTileListTypes(tileList4, typePattern5);
                        logic.setTileListTypes(tileList5, typePattern6);
                        break;
                    case 15:
                        logic.setTileListTypes(tileList1, typePattern3);
                        logic.setTileListTypes(tileList2, typePattern4);
                        logic.setTileListTypes(tileList3, typePattern5);
                        logic.setTileListTypes(tileList4, typePattern6);
                        logic.setTileListTypes(tileList5, typePattern7);
                        break;
                    case 16:
                        logic.setTileListTypes(tileList1, typePattern4);
                        logic.setTileListTypes(tileList2, typePattern5);
                        logic.setTileListTypes(tileList3, typePattern6);
                        logic.setTileListTypes(tileList4, typePattern7);
                        logic.setTileListTypes(tileList5, typePattern8);
                        break;
                    case 17:
                        logic.setTileListTypes(tileList1, typePattern5);
                        logic.setTileListTypes(tileList2, typePattern6);
                        logic.setTileListTypes(tileList3, typePattern7);
                        logic.setTileListTypes(tileList4, typePattern8);
                        logic.setTileListTypes(tileList5, typePattern9);
                        break;
                    case 18:
                        logic.setTileListTypes(tileList1, typePattern6);
                        logic.setTileListTypes(tileList2, typePattern7);
                        logic.setTileListTypes(tileList3, typePattern8);
                        logic.setTileListTypes(tileList4, typePattern9);
                        logic.setTileListTypes(tileList5, typePattern10);
                        break;
                }
                //endregion
                //region TILELIST DRAWING
                drawTileList(g2, tileList1);
                drawTileList(g2, tileList2);
                drawTileList(g2, tileList3);
                drawTileList(g2, tileList4);
                drawTileList(g2, tileList5);
                //endregion

                Image playerImage = logic.player.getImage();
                Image enemyImage = logic.enemy.getImage();
                Image pointRedImage = logic.point.getImage();
                Image pointBlueImage = logic.point2.getImage();
                if (logic.spriteNum == 1) {
                    playerImage = logic.player.getImage();
                    enemyImage = logic.enemy.getImage();
                    pointRedImage = logic.point.getImage();
                    pointBlueImage = logic.point2.getImage();

                } else if (logic.spriteNum == 2) {
                    playerImage = logic.player.getImage2();
                    enemyImage = logic.enemy.getImage2();
                    pointRedImage = logic.point.getImage2();
                    pointBlueImage = logic.point2.getImage2();
                }

                g2.drawImage(playerImage, logic.player.getCoord().x, logic.player.getCoord().y, tileSize, tileSize, null);
                g2.drawImage(pointRedImage, logic.point.getCoord().x, logic.point.getCoord().y, tileSize, tileSize, null);
                g2.drawImage(pointBlueImage, logic.point2.getCoord().x, logic.point2.getCoord().y, tileSize, tileSize, null);
                g2.drawImage(enemyImage, logic.enemy.getCoord().x, logic.enemy.getCoord().y, tileSize, tileSize, null);

                if (logic.getTileListTypes(tileLists) == "red") {
                    logic.game.subtract = 10;
                    logic.pointsRed -= 1;
                    logic.pointsBlue -= 1;
                } else {
                    logic.game.subtract = 1;
                }


                //region TEXT DRAWING
                g2.setFont(myFont2);
                g2.setColor(Color.blue);
                g2.drawString("Blue: " + logic.pointsBlue, 652, 52);
                g2.setColor(Color.WHITE);
                g2.drawString("Blue: " + logic.pointsBlue, 650, 50);
                g2.setColor(Color.red);
                g2.drawString("Red: " + logic.pointsRed, 892, 52);
                g2.setColor(Color.WHITE);
                g2.drawString("Red: " + logic.pointsRed, 890, 50);
                g2.setFont(myFont2);
                g2.setColor(Color.green);
                g2.drawString("Hp: " + logic.enemy.getHp(), 652, 202);
                g2.setColor(Color.WHITE);
                g2.drawString("Hp: " + logic.enemy.getHp(), 650, 200);

                g2.setColor(Color.BLACK);
                g2.drawString("Time: " + logic.getFormattedTime(), 10, 700);

                g2.setColor(Color.BLACK);
                g2.drawString("GameLevel: " + logic.gameLevel, 725, 700);

                setFont(myFont3);
                g2.setColor(Color.RED);
                g2.drawString("-100 red", 940,305);
                g2.setColor(Color.WHITE);
                g2.drawString("-100 red", 938,303);


                g2.setColor(Color.BLUE);
                g2.drawString("-50 blue", 940,430);
                g2.setColor(Color.WHITE);
                g2.drawString("-50 blue", 938,428);
                g2.setColor(Color.RED);
                g2.drawString("-50 red", 940,480);
                g2.setColor(Color.WHITE);
                g2.drawString("-50 red", 938,478);

                g2.setColor(Color.BLUE);
                g2.drawString("-100 blue", 940,580);
                g2.setColor(Color.WHITE);
                g2.drawString("-100 blue", 938,578);




                //endregion

                for (GameButton button : buttons) {
                    g2.drawImage(button.getImage(), button.getX(), button.getY(), tileSize * 2 +45, tileSize, null);
                    g2.setColor(Color.CYAN);
                    g2.drawString(button.getType(), button.getX() + 30, button.getY() + 80);
                    g2.setColor(Color.BLACK);
                    g2.drawString(button.getType(), button.getX() + 33, button.getY() + 83);
                }
            }else if(logic.gameLevel == 0){
                setFont(myFont4);
                setBackground((Color.BLACK));
                g2.setColor(Color.WHITE);
                g2.drawString("GRAB BLUE AND RED POINTS", 425, 280);
                g2.drawString("DONT TOUCH THE RED SPACES", 425, 340);
                g2.drawString("BUY ATTACKS WITH POINTS", 425, 400);
                g2.drawString("DEFEAT THE ENEMY BEFORE THE TIME RUNS OUT ", 425, 460);

                g2.drawString("MADE BY JOSEF JUNGR OF 2.I.", 675, 700);
                for (GameButton button : buttonsMenu) {
                    g2.setFont(myFont2);
                    g2.drawImage(button.getImage(), button.getX(), button.getY(), tileSize * 2, tileSize, null);
                    g2.setColor(Color.CYAN);
                    g2.drawString(button.getType(), button.getX() + 30, button.getY() + 80);
                    g2.setColor(Color.BLACK);
                    g2.drawString(button.getType(), button.getX() + 33, button.getY() + 83);
                }
                g2.drawImage(imageLogo,0,0,width+100,height+100,null);
            }else if (logic.gameLevel < 0){
                setBackground((Color.BLACK));
                setFont(myFont3);
                g2.setFont(myFont2);
                g2.drawImage(logic.buttonGameOver.getImage(), logic.buttonGameOver.getX(), logic.buttonGameOver.getY(), tileSize * 3, tileSize, null);
                g2.setColor(Color.CYAN);
                g2.drawString("TRY AGAIN", logic.buttonGameOver.getX() + 50, logic.buttonGameOver.getY() + 80);
                g2.setColor(Color.BLACK);
                g2.drawString("TRY AGAIN", logic.buttonGameOver.getX() + 53, logic.buttonGameOver.getY() + 83);
                g2.drawImage(imageGameover,0,0,width,height,null);
            }
            g2.dispose(); // Dispose of this graphics context and release any system resources that is it using
        }

    }
    public void setWindowSize(int width, int height) { //sets the window size
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
    }

    public void drawTileList(Graphics2D g, ArrayList<Tile> list){
        for(Tile tile:list){
            g.drawImage(tile.getImage(),tile.getX(),tile.getY(),tileSize,tileSize,null);
        }
    }
    public void render(GameLogic logic) { //renders the graphics
        this.logic = logic;
        repaint();
    }

}
