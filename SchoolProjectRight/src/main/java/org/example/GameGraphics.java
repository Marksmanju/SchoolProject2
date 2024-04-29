package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameGraphics extends JFrame{
    public Draw draw;
    GameLogic logic;
    final int ogTileSize = 32; //original tile size
    final int scale = 3; // scale of the sprites
    public final int tileSize = ogTileSize * scale; // size of individual tiles
    final int maxScrCol = 8; // maximum screen column og 8
    final int maxScrRow = 6; // maximum screen row

    public final int scrWidth = tileSize * maxScrCol; // screen width,
    public final int scrHeight = tileSize * maxScrRow; // screen height,
    //KeyManager keyManager= new KeyManager();
    public GameGraphics(GameLogic logic) throws HeadlessException {
        this.draw = new Draw();
        add(draw);
        this.logic = logic;
        setSize(scrWidth, scrHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setTitle("sfdsd");

    }

    public class Draw extends JPanel {
        public void paintComponent(Graphics g) { // draws graphics, like the draw event in GMS2
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g; // Graphics2D class extends the Grapgics class to provide more sophisticated control over geometrz, coordinta transformations, color management, and text layout.
            setBackground((Color.BLACK)); // background color of the window
            //g2.setColor(Color.BLACK); // guess what is sets the color of the graphic

            //g2.setColor(Color.cyan); // guess what is sets the color of the graphic
            //g2.fillRect(logic.player.getCoord().x,logic.player.getCoord().y,tileSize,tileSize); //fills the rectangle, (x of the object, y of the object, xscale of object, y scale of object)

            g2.drawImage(logic.player.getImage(),logic.player.getCoord().x,logic.player.getCoord().y,tileSize,tileSize,null);

            g2.dispose(); // Dispose of this graphics context and release any system resources that is it using
        }

    }
    public void setWindowSize(int width, int height) { //sets the window size
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
    }

    public void render(GameLogic logic) {
        this.logic = logic;
        repaint();
    }



}
