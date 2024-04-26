package com.aditya.gaming;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Timer; // timer 

import javax.imageio.ImageIO;

import com.aditya.gaming.sprites.*;// star istemal karta toh kya hota

public class Board extends JPanel {
    BufferedImage backgroundImage; //NO1a
    Player player;
    Plane plane;
    Missile missiles []= new Missile[4];
    Explosion explosions []=new Explosion[4];
    Timer timer;

    public Board(){
        setSize(1500,920);
        loadBackgroundImage();
        player = new Player();
        //plane = new Plane();
        loadMissiles();
        MovePlane();
        loadExplosion();

        gameLoop();
        bindEvents();
        setFocusable(true);
    }

    private void bindEvents(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){
    
            }
            @Override
            public void keyReleased(KeyEvent e){
                player.speed = 0;
    
            }
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    player.speed = 20;
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    player.speed = -10;
                }
            }
            
            
        });
    }

    private void gameOver(Graphics pen){

        if(player.outOfScreen()){
            pen.setFont(new Font("Jokerman", Font.BOLD,50 ));
            pen.setColor(Color.GREEN);
            pen.drawString("Game Win", 1500/2, 900/2);
            timer.stop();
            return;
        }
        else{
        for(Missile missile : missiles){
            if(isCollide(missile)){
                pen.setFont(new Font("Jokerman", Font.BOLD,50 ));
                pen.setColor(Color.RED);
                pen.drawString("Game Over", 1500/2, 900/2);
                timer.stop();
            }

        }}
    }
    // private boolean isCollide(Missile missile){
    //     int xDistance = Math.abs(player.x - missile.x);
    //     int yDistance = Math.abs(player.y - missile.y);
    //     int maxH = Math.max(player.h, missile.h);
    //     int maxW = Math.max(player.w, missile.w);
    //     return xDistance <= maxW-70 && yDistance <= maxH-120;
  
    // }

    private boolean isCollide(Missile missile) {
        // Calculate the sides of rect A (Player)
        int leftA = player.x+10;
        int rightA = player.x + player.w-10;
        int topA = player.y;
        int bottomA = player.y + player.h -70;
    
        // Calculate the sides of rect B (Missile)
        int leftB = missile.x+10;
        int rightB = missile.x + missile.w-10;
        int topB = missile.y+20;
        int bottomB = missile.y + missile.h-37;
    
        // If any of the sides from A are outside of B
        if (bottomA <= topB) {
            return false;
        }
        if (topA >= bottomB) {
            return false;
        }
        if (rightA <= leftB) {
            return false;
        }
        if (leftA >= rightB) {
            return false;
        }
    
        // If none of the sides from A are outside B
        return true;
    }
    

    private void loadMissiles(){
        int x = 625;
        int gap = 200;
        int speed = 5 ;
        for(int i =0; i<missiles.length;i++){
            missiles[i] = new Missile(x,speed);
            x = x + gap;
            speed = speed + 2; 
        }

    }

    private void MovePlane(){
        int speed = 0 ;
        for(int i =0; i<5;i++){
            plane = new Plane(speed);
            speed = speed + 5; 
        }

    }
    
    private void loadExplosion(){
        int x = 600;
        int gap = 200;
        for(int i =0; i<explosions.length;i++){
            explosions[i] = new Explosion(x);
            x = x + gap;
        }

    }

    private void gameLoop(){
        timer = new Timer(30,(e)->repaint());
        timer.start();

    }
    // responsible for painting

    //NO1a--(loading the background image)--gotoNO1b --(object creation)
    private void loadBackgroundImage(){  
        try {
            backgroundImage=ImageIO.read(Board.class.getResource("MarinesNo2.jpg"));
        } catch (IOException e) {
            System.out.println("BackGround image not found");
            System.exit(1);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    private void printMissiles(Graphics pen){
        for(Missile missile : missiles){
            missile.draw(pen);
            missile.move();
        }
    }
    private void printPlane(Graphics pen){
            plane.draw(pen);
            plane.move();
    }

    private void printExplosions(Graphics pen){
        for(Explosion explosion : explosions){
            explosion.draw(pen);
        }
    }
    



    @Override
    public void paintComponent(Graphics pen){
        super.paintComponent(pen);// clean up
        // all printing logic will be t=here and 
        pen.drawImage(backgroundImage,0,0,1550,920,null);// #gotoNO1a--NO1b
        player.draw(pen);
        player.move();
        //plane.draw(pen);
        printMissiles(pen);
        printPlane(pen);
        printExplosions(pen);
        gameOver(pen);


    }
}
