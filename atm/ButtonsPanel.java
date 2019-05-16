 /* File: ButtonsPanel.java
 * Author: Vikram Pendyam
 * Date: Feb 8, 2019
 * Purpose: This class 
 * displays all the button functionality
 */
package atm;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonsPanel extends JPanel {
    private SimpleATMPanel scPanel;
    private Account ac = new Account();
    private JButton withDrawBtn = new JButton("Withdraw");//button for withdraw
    private JButton transferBtn = new JButton("Transfer to");//transfer amount
    private JButton depositBtn = new JButton("Deposit");//transfer amount
    private JButton balanceBtn = new JButton("Balance");//balance button
    private JRadioButton checkingRadioBtn = new JRadioButton("Checking", true);//radio button for checking
    private JRadioButton savingRadioBtn = new JRadioButton("Savings");//radia button for saving
    
    public ButtonsPanel(SimpleATMPanel scPanel){ 
        this.scPanel=scPanel;
        
        setLayout(new FlowLayout());
        add(withDrawBtn); add(depositBtn);add(transferBtn);add(balanceBtn);//all required buttons
        //deposit
        depositBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          doDeposit();//deposit methos
          
            }});
        //balance button
        balanceBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
           showBalance();  
            }});
        
        //transfer
        transferBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             doTransfer(); 
             
            }
        });
        //withdraw
        withDrawBtn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
           doWithdraw();  
            
          }  
        });
         
       add(checkingRadioBtn);
       add(savingRadioBtn);
       ButtonGroup typeRadioButtons = new ButtonGroup();   //grouping radiobuttons
      typeRadioButtons.add(checkingRadioBtn);
      typeRadioButtons.add(savingRadioBtn); 

        checkingRadioBtn.addItemListener(new ItemListener() {//handling ra
            public void itemStateChanged(ItemEvent e) {
                ac.setAccountType(0);
            }
        });

        savingRadioBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                ac.setAccountType(1);
            }
        });
    }
    //deposit method
    public void doDeposit() {
        double deposit = scPanel.ioPanel.getresultTxt();
        boolean chkIncremental = scPanel.ioPanel.isIncremental(deposit);
        if (deposit > 0 && chkIncremental) {
            ac.addDeposit(deposit);
            JOptionPane.showMessageDialog(null, "Deposit Succesful");
        } else if(!chkIncremental) {
            JOptionPane.showMessageDialog(null, "Invalid amount, Need amount increments of 20");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid amount");
        }
    }
    //withdraw method
    public void doWithdraw() {
        try {
            double amount = scPanel.ioPanel.getresultTxt();
            boolean chkIncremental = scPanel.ioPanel.isIncremental(amount);
            if ((amount + ac.fee) <= ac.getBalance() && chkIncremental) {
                ac.withdraw(amount);
                JOptionPane.showMessageDialog(null,"Withdrawl Successful");
            } else if (!chkIncremental) {

                JOptionPane.showMessageDialog(null, "Amount incremental 20 allowed");
            } else {
                throw new InsufficientFunds(Double.toString(amount));
            }
        } catch (IllegalArgumentException | InsufficientFunds e) {

            JOptionPane.showMessageDialog(null, "Withdrawl is more than the current balance");
        }
    }
    
//show balance
    public void showBalance(){
        if(ac.getAccountType() == 0){
        JOptionPane.showMessageDialog(null,"Checking Balance:"+ ac.getBalance());
        }else{
         JOptionPane.showMessageDialog(null,"Savings Balance:"+ ac.getBalance());  
        }
    }
 //transfer method   
    public void doTransfer(){
        double amount = scPanel.ioPanel.getresultTxt();
        int i=0;
        if (ac.getAccountType() == 0)
             i=1;
     
        if((amount + ac.fee) <= ac.getBalance(i)){
                ac.transferTo(amount); 
                 JOptionPane.showMessageDialog(null,"Transfer successful");
             }else{
                JOptionPane.showMessageDialog(null,"Transfer is more than the current balance"); 
            }
        
    }
  
}
