package entity;

import main.gamePanel;
import main.keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends entity{
    gamePanel gp;
    keyboard keyH;

    public Player(gamePanel gp, keyboard keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 550;
        y = 400;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try {
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_2.png"));
            idle1 = ImageIO.read(getClass().getResourceAsStream("/player/idle_2.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/idle_1.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/idle_1.png"));
            basketball = ImageIO.read(getClass().getResourceAsStream("/player/basketball.png"));
            shot1 = ImageIO.read(getClass().getResourceAsStream("/player/shot_1.png"));
            shot2 = ImageIO.read(getClass().getResourceAsStream("/player/shot_2.png"));
            shot3 = ImageIO.read(getClass().getResourceAsStream("/player/shot_3.png"));
            shot4 = ImageIO.read(getClass().getResourceAsStream("/player/shot_4.png"));
            released = ImageIO.read(getClass().getResourceAsStream("/player/released.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
            if(keyH.upPressed == true){
                y -= speed;//Y values increase going down
                direction = "up";
            }
            else if(keyH.downPressed == true){
                y += speed;
                direction = "down";
            }
            else if(keyH.leftPressed == true){
                x -= speed; //X values increase going right
                direction = "left";
            }
            else if(keyH.rightPressed == true){
                x += speed;
                direction = "right";
            }
            else if(keyH.upPressed != true && keyH.downPressed != true && keyH.leftPressed != true && keyH.rightPressed != true && keyH.spacePressed != true && keyH.spaceReleased != true) {
                direction = "idle";
            }
            else if(keyH.spacePressed == true){
                direction = "shoot";
            }
            else if(keyH.spaceReleased == true){
                direction = "released";
            }

            spriteCounter++;
            if(spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

    }
    public void draw(Graphics g2){
//
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if (spriteNum == 1){
                image = right1;
                }
                if (spriteNum == 2){
                image = right2;
                }
                if (spriteNum == 3){
                image = right3;
                }
                if (spriteNum == 4){
                image = right4;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                if (spriteNum == 4){
                    image = right4;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                if (spriteNum == 4){
                    image = right4;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                if (spriteNum == 4){
                    image = right4;
                }
                break;
            case "idle":
                if (spriteNum == 1){
                    image = idle1;
                }
                if (spriteNum == 2){
                    image = idle2;
                }
                if (spriteNum == 3){
                    image = idle3;
                }
                if (spriteNum == 4){
                    image = idle4;
                }
                break;
            case "shoot":
                if (spriteNum == 1){
                    image = shot1;
                }
                if (spriteNum == 2){
                    image = shot2;
                }
                if (spriteNum == 3){
                    image = shot3;
                }
                if (spriteNum == 4){
                    image = shot4;
                }
                break;
            case "released":
                if (spriteNum == 1){
                    image = shot4;
                }
                if (spriteNum == 2){
                    image = shot4;
                }
                if (spriteNum == 3){
                    image = shot4;
                }
                if (spriteNum == 4){
                    image = shot4;
                }
                break;
        }

    }

}
