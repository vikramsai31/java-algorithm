/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author vpendyam
 */

import javax.swing.*;
import java.awt.*;

public class NiceFrame extends JFrame {
       static final int WIDTH = 300, HEIGHT = 150;
   public NiceFrame() {
      super("Nice Frame"); 
      setFrame(WIDTH, HEIGHT);
   }	
   public NiceFrame(String title) {
      super(title);  
      setFrame(WIDTH, HEIGHT);
   }
   public NiceFrame(String title, int width, int height) {
      super(title);        				
      setFrame(width, height);
   }
   public void display() {
      setVisible(true);
   }
   private void setFrame(int width, int height) {
      setSize(width, height);     
      setLocationRelativeTo(null);  		
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
    
    
}



