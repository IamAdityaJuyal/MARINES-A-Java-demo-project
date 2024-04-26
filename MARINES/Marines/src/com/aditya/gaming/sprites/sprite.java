package com.aditya.gaming.sprites;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public abstract class  sprite {
    public int x ,y,w, h;
    public ImageIcon image;
    public int speed;

    public void draw(Graphics pen){
        pen.drawImage(image.getImage(), x, y,w,h, null);

    }
    public void move(){
        
        x=x+speed;

    }

    public boolean outOfScreen(){
        return x>1350;

    }
    
}
