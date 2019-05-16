/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author vpendyam
 */
public class Gcd extends JFrame {
    
   static final int WIDTH = 300, HEIGHT = 400;
    public ButtonPanels btnPanel = new ButtonPanels();
    public Gcd() {
      super("GCD");       
      setFrame(WIDTH, HEIGHT);
      add(btnPanel);
        addWindowListener(new WindowAdapter() {//using Window adpater
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

   }
    
    private void setFrame(int width, int height ){//set frame size
        setSize(width, height);
        setLocationRelativeTo(null);
    }
    
    public void display() {
        setVisible(true);//initiate visible
    }
    
    public static void main(String[] args) {
         Gcd g3 = new Gcd();
         g3.display();
    }
    
}
