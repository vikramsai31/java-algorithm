 /* File: Account.java
 * Author: Vikram Pendyam
 * Date: Feb 8, 2019
 * Purpose:Class that handles all the acxcount details
 */
package atm;

/**
 *
 * @author vpendyam
 */
public class Account {
    public static final double fee = 1.50;
    private double[] balance;
    private int account_type;
   //default constructor 
    //0--checking
    //1--saving
    public Account(){
        this.balance=new double[2];
        this.account_type=0;
        
    }
    public Account(double balance,int account_type){
        this.balance[account_type]= balance;
        this.account_type=account_type;
        
    }
    //debugging method 
    public double info(){
        if(this.account_type == 0){
        System.out.println("Checkingh balance: " + this.balance[account_type]);
        }else{
         System.out.println("Saving balance: " + this.balance[account_type]);   
        }
        return this.balance[account_type];
    }
      //setter method
    public void setAccountType(int account_type){		
		this.account_type=account_type;	
    }
    //getter method
    public double getAccountType(){		
		return 	this.account_type;
    }
    //setter for balance
    public void setBalance(double balance, int account_type) {
        this.balance[account_type] = balance;
    }
    //getter for balance
    public double getBalance() {
        return this.balance[this.account_type];
    }

    public double getBalance(int account_type){		
		return 	this.balance[account_type];
    }
    public void addDeposit(double amount){
		System.out.println("\n**Account balance updated**");
		this.balance[this.account_type] = this.balance[this.account_type] + amount;
		this.info();
    }
    
    public void withdraw(double amount){
		System.out.println("\n**Account balance updated**");
		this.balance[this.account_type] = this.balance[this.account_type] - amount - fee;
		this.info();
    }
    //tranfer method
    public void transferTo(double amount) {
        if (this.account_type == 0) {
            this.balance[1] = this.balance[1] - amount - fee;
            this.balance[0] = this.balance[0] + amount;

        } else {

            this.balance[0] = this.balance[0] - amount - fee;
            this.balance[1] = this.balance[1] + amount;
            System.out.println("checking:" + this.balance[0]);
            System.out.println("savings:" + this.balance[1]);

        }
    }
    

    
    
}
