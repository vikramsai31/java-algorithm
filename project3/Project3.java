 /* File: Project3.java
 * Author: Vikram Pendyam
 * Date: Feb 20, 2019
 * Purpose: This class 
 * displays the frame and build csv file
 */
package project3;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class Project3 extends JFrame{
    static final int WIDTH = 300, HEIGHT = 300;
    public ButtonsPanel btnPanel = new ButtonsPanel();
    public Project3() {
      super("Project 3");       
      setFrame(WIDTH, HEIGHT);
      add(btnPanel);
        addWindowListener(new WindowAdapter() {//using Window adpater
            public void windowClosing(WindowEvent e) {
               //exporting data to csv 
                dataToCsv();
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
    //Method to covert data into CSV
    public void dataToCsv(){
        try{
        PrintWriter pw = new PrintWriter(new File("computeIterativeAndRecursive.csv"));
        StringBuffer fileHeader =  new StringBuffer("");
        StringBuffer computeData = new StringBuffer("");
        fileHeader.append("nValue,IterativeEfficiency,RecursiveEfficiency\n");
        pw.write(fileHeader.toString());
        
        int nValue;
        int iterEff;
        int recEff;
        for(int i=0;i<= 10; i++){
            computeData.append(""+i+"");
            computeData.append(",");
            
            nValue=Sequence.computeIterative(i);
            iterEff= Sequence.getEfficiency();
            computeData.append(""+iterEff+"");
            computeData.append(",");
            
            nValue=Sequence.computeRecursive(i);
            recEff=Sequence.getEfficiency();
            computeData.append(""+recEff+"");
           
            computeData.append('\n');
            
        }
        pw.write(computeData.toString());
        pw.close();
        
        } catch(FileNotFoundException e){//exception when file not found
            e.printStackTrace();
        }
        
       
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        Project3 p3 = new Project3();
         p3.display();
        
    }
    
}


