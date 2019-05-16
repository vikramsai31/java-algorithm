/**
 * Filename: CMSC350Project4.java 
 * Author: vikram Pendyam Date: 05/09/2019
 * Description: This is the main class which extends frame and calls the
 * buttonPanel class
 * 
*/
package cmsc350project4;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author vpendyam
 */
public class CMSC350Project4 extends JFrame {
//setting the width and height of the frame

    static final int WIDTH = 300, HEIGHT = 400;
    public ButtonPanels btnPanel = new ButtonPanels();
//constructor where all frame objects are called inlcuding button panel

    public CMSC350Project4() {
        super("Class Dependency Graph"); //label for the frame
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

    //main class where CMSC350Project4 is instantiated
    public static void main(String[] args) {

        //Instantiating  CMSC350Project4
        CMSC350Project4 sc = new CMSC350Project4();
        //displaying the GUI
        sc.display();

    }

}
