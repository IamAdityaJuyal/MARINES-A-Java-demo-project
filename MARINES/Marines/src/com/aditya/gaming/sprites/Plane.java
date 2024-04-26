package com.aditya.gaming.sprites;

import javax.swing.ImageIcon;


public class Plane extends sprite {
    public Plane(int speed){
        w=480;
        h=222;
        x=700;
        y=1;
        this.speed=speed;
        image = new ImageIcon(Plane.class.getResource("EnemyPlane.gif"));

    }
    public void move(){
        if(x<400){
         x=1100;
        }
        x = x - speed;
 
     }
}
