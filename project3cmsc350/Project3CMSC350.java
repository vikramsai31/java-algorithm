/**
 * Filename: Project3CMSC350.java 
 * Author: vikram Pendyam 
 * Date: 04/18/2019
 * Description:  This is the main class which extends frame and calls the buttonPanel class
 * 
*/
package project3cmsc350;
//importing required packages
import java.util.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class Project3CMSC350 extends JFrame {
//setting the width and height of the frame
    static final int WIDTH = 200, HEIGHT = 400;
    public ButtonPanels btnPanel = new ButtonPanels();
//constructor where all frame objects are called inlcuding button panel
    public Project3CMSC350() {
        super("Binary Search Tree Sort"); //label for the frame
        setSize(WIDTH, HEIGHT);//setting the size
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(btnPanel);//add button and texts panels

    }
//actual display of frame is initiated
    public void display() {
        pack();
        setVisible(true);//setting visibility
    }

 //main class where Project3CMSC350 is instantiated
    public static void main(String[] args) {
       
      //Instantiating  Project3CMSC350
        Project3CMSC350 sc = new Project3CMSC350();
        //displaying the GUI
        sc.display();
       
    }

}
