package com.aditya.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame{ // Jframe is a G
    // lets get frame  ready, character
    public GameFrame(){
        Board board = new Board();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the window on exit  // this have the reference no of the object , current calling address , by default lag jata hai we dont need to put it 
        setTitle("Marines:Call of Duty");
        setSize(1550,920);//set size
        setResizable(false);// remove maximise
        setLocationRelativeTo(null);
        
        add(board);
        setVisible(true);//set visible
    }
    

    public static void main(String[] args) {
        new GameFrame();
        
    }
}

