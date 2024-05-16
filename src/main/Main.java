package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close upon clicking X
        //window.setResizable(false); if needed to lock window
        window.setTitle("Basketball Game");

        gamePanel gamePanel = new gamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);//sets window screen to center which is null
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}