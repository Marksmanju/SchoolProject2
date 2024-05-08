package org.example;

import org.example.objects.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameGraphics extends JFrame{
    public Draw draw;
    GameLogic logic;
    final int ogTileSize = 32; //original tile size
    final int scale = 4; // scale of the sprites
    public final int tileSize = ogTileSize * scale; // size of individual tiles
    final int maxScrCol = 9; // maximum screen column og 8
    final int maxScrRow = 6; // maximum screen row

    public final int scrWidth = tileSize * maxScrCol; // screen width,
    public final int scrHeight = tileSize * maxScrRow; // screen height,



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

        Tile tile0_0 = new Tile(tileSize*0,tileSize*0,"green");
        Tile tile1_0 = new Tile(tileSize*1,tileSize*0,"blue");
        Tile tile2_0 = new Tile(tileSize*2,tileSize*0,"yellow");
        Tile tile3_0 = new Tile(tileSize*3,tileSize*0,"red");
        //2 ROW
        Tile tile0_1 = new Tile(tileSize*0,tileSize*1,"yellow");
        Tile tile1_1 = new Tile(tileSize*1,tileSize*1,"red");
        Tile tile2_1 = new Tile(tileSize*2,tileSize*1,"green");
        Tile tile3_1 = new Tile(tileSize*3,tileSize*1,"blue");
        //3 ROW
        Tile tile0_2 = new Tile(tileSize*0,tileSize*2,"green");
        Tile tile1_2 = new Tile(tileSize*1,tileSize*2,"blue");
        Tile tile2_2 = new Tile(tileSize*2,tileSize*2,"yellow");
        Tile tile3_2 = new Tile(tileSize*3,tileSize*2,"red");
        //4 ROW
        Tile tile0_3 = new Tile(tileSize*0,tileSize*3,"yellow");
        Tile tile1_3 = new Tile(tileSize*1,tileSize*3,"red");
        Tile tile2_3 = new Tile(tileSize*2,tileSize*3,"green");
        Tile tile3_3 = new Tile(tileSize*3,tileSize*3,"blue");
        ArrayList<Tile> tileList1 = new ArrayList<Tile>();
        tileList1.add(tile0_0);
        tileList1.add(tile1_0);
        tileList1.add(tile2_0);
        tileList1.add(tile3_0);

    }



    public class Draw extends JPanel {
        Tile tile0_0 = new Tile(tileSize*0,tileSize*0,"green");
        Tile tile1_0 = new Tile(tileSize*1,tileSize*0,"blue");
        Tile tile2_0 = new Tile(tileSize*2,tileSize*0,"yellow");
        Tile tile3_0 = new Tile(tileSize*3,tileSize*0,"red");
        //2 ROW
        Tile tile0_1 = new Tile(tileSize*0,tileSize*1,"yellow");
        Tile tile1_1 = new Tile(tileSize*1,tileSize*1,"red");
        Tile tile2_1 = new Tile(tileSize*2,tileSize*1,"green");
        Tile tile3_1 = new Tile(tileSize*3,tileSize*1,"blue");
        //3 ROW
        Tile tile0_2 = new Tile(tileSize*0,tileSize*2,"green");
        Tile tile1_2 = new Tile(tileSize*1,tileSize*2,"blue");
        Tile tile2_2 = new Tile(tileSize*2,tileSize*2,"yellow");
        Tile tile3_2 = new Tile(tileSize*3,tileSize*2,"red");
        //4 ROW
        Tile tile0_3 = new Tile(tileSize*0,tileSize*3,"yellow");
        Tile tile1_3 = new Tile(tileSize*1,tileSize*3,"red");
        Tile tile2_3 = new Tile(tileSize*2,tileSize*3,"green");
        Tile tile3_3 = new Tile(tileSize*3,tileSize*3,"blue");



        public void paintComponent(Graphics g) { // draws graphics, like the draw event in GMS2
            super.paintComponent(g);

            ArrayList<Tile> tileList1 = new ArrayList<Tile>();
            ArrayList<Tile> tileList2 = new ArrayList<Tile>();
            ArrayList<Tile> tileList3 = new ArrayList<Tile>();
            ArrayList<Tile> tileList4 = new ArrayList<Tile>();

            tileList1.add(tile0_0);
            tileList1.add(tile1_0);
            tileList1.add(tile2_0);
            tileList1.add(tile3_0);

            tileList2.add(tile0_1);
            tileList2.add(tile1_1);
            tileList2.add(tile2_1);
            tileList2.add(tile3_1);

            tileList3.add(tile0_2);
            tileList3.add(tile1_2);
            tileList3.add(tile2_2);
            tileList3.add(tile3_2);

            tileList4.add(tile0_3);
            tileList4.add(tile1_3);
            tileList4.add(tile2_3);
            tileList4.add(tile3_3);

            Graphics2D g2 = (Graphics2D) g; // Graphics2D class extends the Grapgics class to provide more sophisticated control over geometrz, coordinta transformations, color management, and text layout.
            setBackground((Color.BLACK)); // background color of the window
            //g2.setColor(Color.BLACK); // guess what is sets the color of the graphic

            int pattern = logic.pattern;

            switch (pattern) {
                case 1:
                    tileList1.get(0).updateType("blue");
                    tileList1.get(1).updateType("blue");
                    tileList1.get(2).updateType("blue");
                    tileList1.get(3).updateType("blue");

                    tileList2.get(0).updateType("red");
                    tileList2.get(1).updateType("red");
                    tileList2.get(2).updateType("red");
                    tileList2.get(3).updateType("red");

                    tileList3.get(0).updateType("yellow");
                    tileList3.get(1).updateType("yellow");
                    tileList3.get(2).updateType("yellow");
                    tileList3.get(3).updateType("yellow");

                    tileList4.get(0).updateType("green");
                    tileList4.get(1).updateType("green");
                    tileList4.get(2).updateType("green");
                    tileList4.get(3).updateType("green");

                    break;
                case 2:
                    tileList1.get(0).updateType("red");
                    tileList1.get(1).updateType("red");
                    tileList1.get(2).updateType("red");
                    tileList1.get(3).updateType("red");

                    tileList2.get(0).updateType("blue");
                    tileList2.get(1).updateType("blue");
                    tileList2.get(2).updateType("blue");
                    tileList2.get(3).updateType("blue");

                    tileList3.get(0).updateType("green");
                    tileList3.get(1).updateType("green");
                    tileList3.get(2).updateType("green");
                    tileList3.get(3).updateType("green");

                    tileList4.get(0).updateType("yellow");
                    tileList4.get(1).updateType("yellow");
                    tileList4.get(2).updateType("yellow");
                    tileList4.get(3).updateType("yellow");
                    break;
                case 3:
                    tileList1.get(0).updateType("yellow");
                    tileList1.get(1).updateType("yellow");
                    tileList1.get(2).updateType("yellow");
                    tileList1.get(3).updateType("yellow");

                    tileList2.get(0).updateType("green");
                    tileList2.get(1).updateType("green");
                    tileList2.get(2).updateType("green");
                    tileList2.get(3).updateType("green");

                    tileList3.get(0).updateType("red");
                    tileList3.get(1).updateType("red");
                    tileList3.get(2).updateType("red");
                    tileList3.get(3).updateType("red");

                    tileList4.get(0).updateType("blue");
                    tileList4.get(1).updateType("blue");
                    tileList4.get(2).updateType("blue");
                    tileList4.get(3).updateType("blue");
                    break;
                case 4:
                    tileList1.get(0).updateType("green");
                    tileList1.get(1).updateType("green");
                    tileList1.get(2).updateType("green");
                    tileList1.get(3).updateType("green");

                    tileList2.get(0).updateType("yellow");
                    tileList2.get(1).updateType("yellow");
                    tileList2.get(2).updateType("yellow");
                    tileList2.get(3).updateType("yellow");

                    tileList3.get(0).updateType("blue");
                    tileList3.get(1).updateType("blue");
                    tileList3.get(2).updateType("blue");
                    tileList3.get(3).updateType("blue");

                    tileList4.get(0).updateType("red");
                    tileList4.get(1).updateType("red");
                    tileList4.get(2).updateType("red");
                    tileList4.get(3).updateType("red");
                    break;
            }


            drawTileList(g2,tileList1);
            drawTileList(g2,tileList2);
            drawTileList(g2,tileList3);
            drawTileList(g2,tileList4);

            //g2.setColor(Color.cyan); // guess what is sets the color of the graphic
            //g2.fillRect(logic.player.getCoord().x,logic.player.getCoord().y,tileSize,tileSize); //fills the rectangle, (x of the object, y of the object, xscale of object, y scale of object)

            /*g2.drawImage(tile0_0.getImage(),tile0_0.getX(),tile0_0.getY(),tileSize,tileSize,null);
            g2.drawImage(tile1_0.getImage(),tile1_0.getX(),tile1_0.getY(),tileSize,tileSize,null);
            g2.drawImage(tile2_0.getImage(),tile2_0.getX(),tile2_0.getY(),tileSize,tileSize,null);
            g2.drawImage(tile3_0.getImage(),tile3_0.getX(),tile3_0.getY(),tileSize,tileSize,null);

            g2.drawImage(tile0_1.getImage(),tile0_1.getX(),tile0_1.getY(),tileSize,tileSize,null);
            g2.drawImage(tile1_1.getImage(),tile1_1.getX(),tile1_1.getY(),tileSize,tileSize,null);
            g2.drawImage(tile2_1.getImage(),tile2_1.getX(),tile2_1.getY(),tileSize,tileSize,null);
            g2.drawImage(tile3_1.getImage(),tile3_1.getX(),tile3_1.getY(),tileSize,tileSize,null);

            g2.drawImage(tile0_2.getImage(),tile0_2.getX(),tile0_2.getY(),tileSize,tileSize,null);
            g2.drawImage(tile1_2.getImage(),tile1_2.getX(),tile1_2.getY(),tileSize,tileSize,null);
            g2.drawImage(tile2_2.getImage(),tile2_2.getX(),tile2_2.getY(),tileSize,tileSize,null);
            g2.drawImage(tile3_2.getImage(),tile3_2.getX(),tile3_2.getY(),tileSize,tileSize,null);

            g2.drawImage(tile0_3.getImage(),tile0_3.getX(),tile0_3.getY(),tileSize,tileSize,null);
            g2.drawImage(tile1_3.getImage(),tile1_3.getX(),tile1_3.getY(),tileSize,tileSize,null);
            g2.drawImage(tile2_3.getImage(),tile2_3.getX(),tile2_3.getY(),tileSize,tileSize,null);
            g2.drawImage(tile3_3.getImage(),tile3_3.getX(),tile3_3.getY(),tileSize,tileSize,null);*/


            g2.drawImage(logic.player.getImage(),logic.player.getCoord().x,logic.player.getCoord().y,tileSize,tileSize,null);
            g2.drawImage(logic.enemy.getImage(),logic.enemy.getCoord().x,logic.enemy.getCoord().y,tileSize,tileSize,null);

            g2.setColor(Color.WHITE);

            g2.drawString("Test",700,50);

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
