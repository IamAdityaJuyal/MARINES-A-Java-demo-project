package com.aditya.gaming.sprites;

// import java.awt.Graphics;

import javax.swing.ImageIcon;
//import java.awt.Graphics;


public class Missile extends sprite {
    // public int x ,y,w, h;
    // public ImageIcon image;
    // int speed;

    public Missile(int x ,int speed){
        w=60;
        h=120;
        this.x =x;
        y=200;
        this.speed= speed;
        image = new ImageIcon(Missile.class.getResource("BOMB.png"));

    }
    // public void draw(Graphics pen){
    //     pen.drawImage(image.getImage(), x, y,w,h, null);

    // }
    public void move(){
       if(y>900){
        y=200;
       }
       y = y + speed;

    }
    
}
