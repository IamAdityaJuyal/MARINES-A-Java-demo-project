package com.aditya.gaming.sprites;

import javax.swing.ImageIcon;


public class Player extends sprite{
    
    public Player(){
        // w=200;
        // h=175;
        // y=650;
        w=400;
        h=150;
        y=700;

        x=40;
        image = new ImageIcon(Player.class.getResource("PlayerNoOne.gif"));
        // image = new ImageIcon(Player.class.getResource("NEZUKOrun1.gif"));

    }
    
    
}
