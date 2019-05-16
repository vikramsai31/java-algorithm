/**
 * Filename: CycleDetectedException.java
 * Author: vikram Pendyam
 * Date: 05/9/2019 Description:
 * Description: raise CycleDetectedException exception
 * 
*/
package cmsc350project4;

/**
 *
 * @author vpendyam
 */
public class CycleDetectedException extends Exception {
    public CycleDetectedException(String message){
        super(message);
    }
    
}
