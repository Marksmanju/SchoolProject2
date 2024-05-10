package org.example;

import org.example.objects.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
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

    }



    public class Draw extends JPanel {
        //1 ROW
        Tile tile0_0 = new Tile(tileSize*0,tileSize*0,"green");
        Tile tile1_0 = new Tile(tileSize*1,tileSize*0,"blue");
        Tile tile2_0 = new Tile(tileSize*2,tileSize*0,"yellow");
        Tile tile3_0 = new Tile(tileSize*3,tileSize*0,"red");
        Tile tile4_0 = new Tile(tileSize*4,tileSize*0,"red");
        //2 ROW
        Tile tile0_1 = new Tile(tileSize*0,tileSize*1,"yellow");
        Tile tile1_1 = new Tile(tileSize*1,tileSize*1,"red");
        Tile tile2_1 = new Tile(tileSize*2,tileSize*1,"green");
        Tile tile3_1 = new Tile(tileSize*3,tileSize*1,"blue");
        Tile tile4_1 = new Tile(tileSize*4,tileSize*1,"blue");
        //3 ROW
        Tile tile0_2 = new Tile(tileSize*0,tileSize*2,"green");
        Tile tile1_2 = new Tile(tileSize*1,tileSize*2,"blue");
        Tile tile2_2 = new Tile(tileSize*2,tileSize*2,"yellow");
        Tile tile3_2 = new Tile(tileSize*3,tileSize*2,"red");
        Tile tile4_2 = new Tile(tileSize*4,tileSize*2,"red");
        //4 ROW
        Tile tile0_3 = new Tile(tileSize*0,tileSize*3,"yellow");
        Tile tile1_3 = new Tile(tileSize*1,tileSize*3,"red");
        Tile tile2_3 = new Tile(tileSize*2,tileSize*3,"green");
        Tile tile3_3 = new Tile(tileSize*3,tileSize*3,"blue");
        Tile tile4_3 = new Tile(tileSize*4,tileSize*3,"blue");
        //5 ROW
        Tile tile0_4 = new Tile(tileSize*0,tileSize*4,"yellow");
        Tile tile1_4 = new Tile(tileSize*1,tileSize*4,"red");
        Tile tile2_4 = new Tile(tileSize*2,tileSize*4,"green");
        Tile tile3_4 = new Tile(tileSize*3,tileSize*4,"blue");
        Tile tile4_4 = new Tile(tileSize*4,tileSize*4,"yellow");



        public void paintComponent(Graphics g) { // draws graphics, like the draw event in GMS2
            super.paintComponent(g);

            ArrayList<Tile> tileList1 = new ArrayList<Tile>();
            ArrayList<Tile> tileList2 = new ArrayList<Tile>();
            ArrayList<Tile> tileList3 = new ArrayList<Tile>();
            ArrayList<Tile> tileList4 = new ArrayList<Tile>();
            ArrayList<Tile> tileList5 = new ArrayList<Tile>();
            ArrayList<ArrayList<Tile>> tileLists = new ArrayList<ArrayList<Tile>>();

            String[] typePattern1 = {"blue", "blue", "blue", "blue", "blue"};
            String[] typePattern2 = {"yellow", "yellow", "yellow", "yellow", "yellow"};
            String[] typePattern3 = {"green", "green", "green", "green", "green"};
            String[] typePattern4 = {"red", "red", "red", "red", "red"};

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

            Graphics2D g2 = (Graphics2D) g; // Graphics2D class extends the Grapgics class to provide more sophisticated control over geometrz, coordinta transformations, color management, and text layout.
            setBackground((Color.BLACK)); // background color of the window
            //g2.setColor(Color.BLACK); // guess what is sets the color of the graphic

            int pattern = logic.pattern;

            switch (pattern) {
                case 1:
                    logic.setTileListTypes(tileList1, typePattern1);
                    logic.setTileListTypes(tileList2, typePattern2);
                    logic.setTileListTypes(tileList3, typePattern3);
                    logic.setTileListTypes(tileList4, typePattern4);
                    logic.setTileListTypes(tileList5, typePattern1);

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
                    logic.setTileListTypes(tileList3, typePattern1);
                    logic.setTileListTypes(tileList4, typePattern2);
                    logic.setTileListTypes(tileList5, typePattern3);
                    break;
                case 4:
                    logic.setTileListTypes(tileList1, typePattern4);
                    logic.setTileListTypes(tileList2, typePattern1);
                    logic.setTileListTypes(tileList3, typePattern2);
                    logic.setTileListTypes(tileList4, typePattern3);
                    logic.setTileListTypes(tileList5, typePattern4);
                    break;
            }


            drawTileList(g2,tileList1);
            drawTileList(g2,tileList2);
            drawTileList(g2,tileList3);
            drawTileList(g2,tileList4);
            drawTileList(g2,tileList5);

            g2.drawImage(logic.player.getImage(),logic.player.getCoord().x,logic.player.getCoord().y,tileSize,tileSize,null);
            g2.drawImage(logic.point.getImage(),logic.point.getCoord().x,logic.point.getCoord().y,tileSize,tileSize,null);

            g2.setColor(Color.WHITE);

            g2.drawString("Points: " + logic.points,700,50);

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
