package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GameGraphics extends JFrame{
    public Draw draw;
    final int ogTileSize = 32; //original tile size
    final int scale = 3; // scale of the sprites
    public final int tileSize = ogTileSize * scale; // size of individual tiles
    public GameGraphics(GameLogic logic){
        this.draw = new Draw();
        add(draw);
        logic = new GameLogic();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        setTitle("sfdsd");
        setSize(650, 450);



    }

    public static class Draw extends JPanel {
        public void paintComponent(Graphics g) { // draws graphics, like the draw event in GMS2
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g; // Graphics2D class extends the Grapgics class to provide more sophisticated control over geometrz, coordinta transformations, color management, and text layout.
            //player.draw(g2);
            g2.setColor(Color.RED); // guess what is sets the color of the graphic
            g2.drawRect(50,50,50,50);
            g2.dispose(); // Dispose of this graphics context and release any system resources that is it using
        }

    }

}
