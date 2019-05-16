 /* File: InfixEvaluator.java
 * Author: Vikram Pendyam
 * Date: Mar 27, 2019
 * Purpose: 
 * This is main class to initiate the GUI
 */
package stacksweek1;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class StacksWeek1 extends JFrame {

    static final int WIDTH = 200, HEIGHT = 200;//setting width and height
    public ButtonPanels btnPanel = new ButtonPanels();//Referencing buttonlabel class where labels and properties are declared

    public StacksWeek1() {
        super("Infix Expression Evaluator"); //label for the frame
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
        StacksWeek1 sw = new StacksWeek1();
        sw.display();

    }

}
