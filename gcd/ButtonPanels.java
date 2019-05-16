 /* File: ButtonsPanel.java
 * Author: Vikram Pendyam
 * Date: Feb 20, 2019
 * Purpose: This class 
 * Builds panel details on the frame
 */
package gcd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanels extends JPanel  {
    
    private JRadioButton iterativeRadioBtn = new JRadioButton("Iterative", true);//radio button for checking
    private JRadioButton recursiveRadioBtn = new JRadioButton("Recursive");
    private JButton computeBtn = new JButton("Compute");//compute button
    private JLabel buttonLbl = new JLabel(" ");
    private JLabel  iterativeLbl= new JLabel("");
    private JLabel  recursiveLbl= new JLabel("");
    private static int actionEvent=0;
    
   private JLabel aLbl = new JLabel("Enter a");//a value
   private JLabel bLbl = new JLabel("Enter b");//a value
    private JLabel resultLbl = new JLabel("Result");//Result field
    private JLabel efficencyLbl = new JLabel("Efficiency");//Efficiency
    private JTextField aTxt = new JTextField(" ");
    private JTextField bTxt = new JTextField(" ");
    private JTextField resultTxt = new JTextField(" ");
    private JTextField efficencyTxt = new JTextField(" ");
    
    public ButtonPanels(){
        setLayout(new GridLayout(7, 5));
        
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
        
        add(aLbl);
        add(aTxt);
        aTxt.setBackground(Color.white);
        
        add(bLbl);
        add(bTxt);
        bTxt.setBackground(Color.white);
        
        //setLayout(new FlowLayout());
        add(buttonLbl);
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
              int a = chkValue(aTxt.getText());
              int b = chkValue(bTxt.getText());
              getValues(a,b,actionEvent);
            }
        });
        
     
    }
    //converts into Strig to integer also clears trailing space
    int chkValue(String label) {
        try{
             return Integer.parseInt(label.trim()); 
        } catch(NumberFormatException e){
            String messageLine1 = "Invalid Number, Enter Whole Number,Check for any space";
            JOptionPane.showMessageDialog(this,messageLine1);
        }
      return 0;   
    } 
    
    

    //setting result and effciency fielf values
    public void getValues(int a,int b, int action){
        int result=0;
        if ( action == 0){
            if ( a > b)
                result = Sequence.computeIterative(a, b); 
            else
                result = Sequence.computeIterative(b, a);
            efficencyTxt.setText(String.valueOf(Sequence.getEfficiency())); 
            
        } else {
            if( a > b)
                result= Sequence.computeRecursive(a,b);
            else
                result= Sequence.computeRecursive(b,a);         
            efficencyTxt.setText(String.valueOf(Sequence.getEfficiency()));
        }
         resultTxt.setText(String.valueOf(result));    
    }
    
}
