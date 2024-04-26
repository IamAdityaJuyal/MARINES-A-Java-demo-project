package com.aditya.gaming.sprites;

import javax.swing.ImageIcon;


public class Explosion extends sprite{
    
    public Explosion(int x){
        w=100;
        h=100;
        y=750;
        this.x=x;
        image = new ImageIcon(Explosion.class.getResource("explosion-gif.gif"));
    

    }
    
    
}

