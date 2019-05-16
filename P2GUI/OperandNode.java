package P2GUI;

import java.io.IOException;

/**
 * Filename: OperandNode.java 
 * Author: vikram Pendyam 
 * Date: 04/08/2019
 * Description: Creates operand nodes in the trees
 */

/*
 @param : value accepts operands
 */
public class OperandNode implements Node {

    private String value;
    /*
     Constructor setting the operand value
     */

    public OperandNode(String value) {
        this.value = value;
    }
    /*
     Returns the operand value
     */

    public String inOrderWalk() {
        return String.valueOf(value);
    }
    /*
     returns the operand value in string form
     */
   
   public String PostOrderWalk() {
       return String.valueOf(value);
    }
   

   
  

}
