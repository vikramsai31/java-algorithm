/**
 * Filename: P2GUI.java 
 * Author: vikram Pendyam 
 * Date: 04/08/2019
 * Description: GUI for Project 2 . Converts Postfix expression to infix expression using 
 * binary tree nodes
 */
package P2GUI;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/*
*Setting static width and height. Using inheritance with JFrame
*/
public class P2GUI extends JFrame{
       static final int WIDTH = 300, HEIGHT = 300;//setting width and height
    public ButtonPanels btnPanel = new ButtonPanels();//Referencing buttonlabel class where labels and properties are declared

    public P2GUI() {
        super("Three Address Generator"); //label for the frame
        setSize(WIDTH, HEIGHT);//setting the size
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(btnPanel);//add button and texts panels

    }

    public void display() {
        pack();
        setVisible(true);//setting visibility
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        P2GUI p2 = new P2GUI();
        p2.display();
       
    }

} 

