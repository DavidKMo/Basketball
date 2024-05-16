package main;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import entity.Player;

public class gamePanel extends JPanel implements Runnable {

    //needs to be public to go to different packages
    //screen settings
    final int originalTileSize = 32; //32x32 tile
    final int scale = 6; // scales characters on screen to match pc resolution
    public int tileSize = originalTileSize * scale; //96x96
    final int maxScreenCol = 18;
    final int maxScreenRow = 10; //ratio 9:5
    final int screenWidth = tileSize * maxScreenCol;//1728
    final int screenHeight = tileSize * maxScreenRow;//960
    //final res = 1728x960 PC res = 1920x1080
    keyboard keyH = new keyboard();
    //FPS
    int FPS = 60;
    Player player = new Player(this,keyH);//from Player class

    double startX = 0;
    double startY = 0;
    double endX = 0;
    double endY = 0;
    double g = 9.81;

    //TileManager tileM = new TileManager(this);


    public gamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.decode("#3b3b3b")); //sets background color use if necessary
        this.setDoubleBuffered(true); //improves performance through buffer
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    //start a "game clock" which means keeps the game running until stopped
    //game runs on loops for animation
    //Thread can be started & stopped
    Thread gameThread;


    public void startGameThread() {
        gameThread = new Thread(this); // "this" means main.gamePanel
        gameThread.start();//calls the run method
    }


    public void run() {
        //run method is called when creating a Thread
        double drawInterval = 1000000000/FPS;//1000000000 divided 60 = 0.166 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;//creates interval

        while (gameThread != null)//shows that game loop is on
        {
            long currentTime = System.nanoTime();//slows down input since modern computers scan one key tap as millions of inputs

            //System.out.println("The game loop is running");
            //1) update information such as character position
            //2) draw screen with updated info (FPS)
            update();
            repaint();//calling paintComponent

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;//sets to milliseconds

                if(remainingTime < 0){//if no time left, value will be set back to 0
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);//will pause until sleep time is over

                nextDrawTime += drawInterval;//sets interval for next draw

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void update() {
        player.update();//calls from player class

    }

    public void updateBall() {
        // Update information such as character position
        // In this method, you can update the position of the ball for animation
        // For example, you can update the x and y coordinates of the ball based on a trajectory

        // Example code for updating ball position in a parabolic trajectory
        double t = (System.nanoTime() - startTime) / 1e9; // Convert nanoseconds to seconds
        double x = startX + (endX - startX) * t; // Linear interpolation for x-coordinate
        double y = startY + (endY - startY) * t - 0.5 * g * t * t; // Parabolic interpolation for y-coordinate

        ball.setTranslateX(x);
        ball.setTranslateY(y);

    }

    public void paintComponent(Graphics g)//standard method to dare things
    {
        super.paintComponent(g);//always use when using paintComponent
        Graphics2D g2 = (Graphics2D) g;//converts Graphics g to Graphics g2 which is 2D and has more functions
        //tileM.draw(g2);
        player.draw(g2);//calls from player class
        g2.dispose();
    }



}