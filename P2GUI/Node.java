
/**
 * Filename: Node.java 
 * Author: vikram Pendyam Date: 04/08/2019
 * Description: Create node inyterface
 */

package P2GUI;

import java.io.IOException;

/**
 *
 * @author vpendyam
 */
public interface Node {
    String inOrderWalk();//building infix expression
    String PostOrderWalk() throws IOException; //postporcessing  
   // void postWork() throws IOException;
    
}
