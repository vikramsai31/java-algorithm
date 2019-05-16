 /* File: InfixEvaluator.java
 * Author: Vikram Pendyam
 * Date: Mar 27, 2019
 * Purpose: 
 * This class to raise exception for division by zero
 */
package stacksweek1;

/**
 *
 * @author vpendyam
 */
public class DivideByZero extends Exception {
    
    public DivideByZero(String message){
        super(message);
        
    }
}
