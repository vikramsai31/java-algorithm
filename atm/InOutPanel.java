 /* File: InOutPanel.java
 * Author: Vikram Pendyam
 * Date: Feb 8, 2019
 * Purpose: This class reads
 * Read input data from GUI 
 */
package atm;

import java.awt.*;
import javax.swing.*;

public class InOutPanel extends JPanel {
    private SimpleATMPanel scPanel; 
    //private JLabel resultLbl = new JLabel("Result", JLabel.CENTER);
    private JTextField resultTxt = new JTextField(15);
    
    public InOutPanel(SimpleATMPanel scPanel){
        this.scPanel=scPanel;
        resultTxt.setBackground(Color.white);
        add(resultTxt); //adding text value in the GUI
        setLayout(new FlowLayout());
    }
    
    double getresultTxt() {
        //check to see if numeric
        if(!isNumeric(resultTxt.getText()) || Double.parseDouble(resultTxt.getText()) <= 0)
            JOptionPane.showMessageDialog(null, "Invalid amount.");
         return Double.parseDouble(resultTxt.getText());      
    } 
    
    //check if record is numeric
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    //checking for incrementals of 20
    public static boolean isIncremental(double amount){
        if(amount%20 != 0)
            return false;
        
        return true;
    }
}
