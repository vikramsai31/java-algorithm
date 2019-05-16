package atm;

 /* File: InsufficientFunds.java
 * Author: Vikram Pendyam
 * Date:  Feb 8, 2019
 * Purpose: Exception class
 *  
 */
public class InsufficientFunds extends Exception {
    public InsufficientFunds(String message){
        super(message);
    }
    
    public InsufficientFunds(String message, Throwable throwable)
    {
        super(message, throwable);//throws exception super class
    }
    
}
