 /* File: ButtonsPanel.java
 * Author: Vikram Pendyam
 * Date: Feb 20, 2019
 * Purpose: This class 
 * Builds panel details on the frame
 */
package project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonsPanel extends JPanel  {
    
    private JRadioButton iterativeRadioBtn = new JRadioButton("Iterative", true);//radio button for checking
    private JRadioButton recursiveRadioBtn = new JRadioButton("Recursive");
    private JButton computeBtn = new JButton("Compute");//compute button
    private JLabel bLbl = new JLabel(" ");
    private JLabel  iterativeLbl= new JLabel("");
    private JLabel  recursiveLbl= new JLabel("");
    private static int actionEvent=0;
    
   private JLabel nLbl = new JLabel("Enter N");//N value
    private JLabel resultLbl = new JLabel("Result");//Result field
    private JLabel efficencyLbl = new JLabel("Efficiency");//Efficiency
    private JTextField nTxt = new JTextField(" ");
    private JTextField resultTxt = new JTextField(" ");
    private JTextField efficencyTxt = new JTextField(" ");
    
    public ButtonsPanel(){
        setLayout(new GridLayout(6, 4));
        
        ButtonGroup computeRadioButtons = new ButtonGroup();
        computeRadioButtons.add(iterativeRadioBtn);
        computeRadioButtons.add(recursiveRadioBtn);
        resultTxt.setEditable(false);
        efficencyTxt.setEditable(false);
        
        add(iterativeLbl);
        add(iterativeRadioBtn);
        
        add(recursiveLbl);
        add(recursiveRadioBtn);
      //commpute button
        
        add(nLbl);
        add(nTxt);
        nTxt.setBackground(Color.white);
        
        //setLayout(new FlowLayout());
        add(bLbl);
        add(computeBtn);
        //text boxes
       
        add(resultLbl);
        add(resultTxt);
        resultTxt.setBackground(Color.white);
        
        
          add(efficencyLbl);
          add(efficencyTxt);
        efficencyTxt.setBackground(Color.white);
        iterativeRadioBtn.addItemListener(new ItemListener() {//handling radiobuttons
            public void itemStateChanged(ItemEvent e) {
                actionEvent =0;//setting radio action event
            }
        });
        
           recursiveRadioBtn.addItemListener(new ItemListener() {//handling radiobuttons
            public void itemStateChanged(ItemEvent e) {
                actionEvent =1;
            }
        });
           
        computeBtn.addActionListener(new ActionListener() {//handling compute button
            public void actionPerformed(ActionEvent e) {
              int n = chkNValue();
              getValues(n,actionEvent);
            }
        });
        
     
    }
    //converts into Strig to integer also clears trailing space
    int chkNValue() {
        try{
             return Integer.parseInt(nTxt.getText().trim()); 
        } catch(NumberFormatException e){
            String messageLine1 = "Invalid Number, Enter Whole Number,Check for any space";
            JOptionPane.showMessageDialog(this,messageLine1);
        }
      return 0;   
    } 

    //setting result and effciency fielf values
    public void getValues(int n, int action){
        int result=0;
        if ( action == 0){
            result = Sequence.computeIterative(n); 
            efficencyTxt.setText(String.valueOf(Sequence.getEfficiency())); 
            
        } else {
            result= Sequence.computeRecursive(n);
            efficencyTxt.setText(String.valueOf(Sequence.getEfficiency()));
        }
         resultTxt.setText(String.valueOf(result));    
    }
    
}
