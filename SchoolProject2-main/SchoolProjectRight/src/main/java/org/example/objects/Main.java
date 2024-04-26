package org.example.objects;

import org.example.Game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new Game();
                Game game = new Game(); //Creates a new game and window
                game.startGameThread(); //Starts the game loop
            }
        });
    }
}
