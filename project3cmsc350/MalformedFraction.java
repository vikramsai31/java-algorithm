/**
 * Filename: MalformedFraction.java 
 * Author: vikram Pendyam 
 * Date: 04/18/2019
 * Description: custom exception to handle malformed exceptioms
 * 
 * 
*/
package project3cmsc350;

/**
 *
 * @author vpendyam
 */
public class MalformedFraction extends Exception{
    public MalformedFraction(String message){
        super(message);//return custom message
        
    }
    
}
