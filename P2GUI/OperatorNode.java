package P2GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Filename: OperatorNode.java Author: vikram Pendyam Date: 04/08/2019
 * Description: Creates operator nodes in the trees
 */

/*
 @param : value accepts operator and implements node
 */
public class OperatorNode implements Node {

    private String operator;
    private Node left, right;
    private static int i=0;
    private String f="3address.txt";

    /**
     * @params operator--> operator actually used in the expression Left-->
     * assign to the left of the tree Right--> assign to the right of the tree
     */
    /*
     OperatorNode constructor along with params
     */
    public OperatorNode(String operator, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        opType(operator);
        
    }
    /*
    *inOrderWalk walks tree in  order and 
    *returns string infix expression value
    */
    public String inOrderWalk() {
        return "(" + left.inOrderWalk() + " " + operator + " " + right.inOrderWalk() + ")";
    }

  
      /*
    *Postorder walks tree in post order and writes to file
    *@IOException throws exception incase file is not found
    */
    
    public String PostOrderWalk() throws IOException {
        
        String opString = opType(this.operator);
       
        
        String increment = "R" + i++;
        String acode = opString + " " + increment + " " + left.PostOrderWalk() + " " + right.PostOrderWalk();
       
        writeToFile(acode);
        
        return increment;
    }
    /*
    *Generates the file
    *@IOException throws exception incase file is not found
    */
    
    
    public void writeToFile(String fileContent) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
        writer.write(fileContent);
        writer.newLine();
        writer.close();
    }

    private String opType(String operator) {
        String optype = "";
        if (operator.matches("\\+")) {
            optype = "ADD";
        } else if (operator.matches("\\-")) {
            optype = "SUB";
        } else if (operator.matches("\\*")) {
            optype = "Mult";
        } else if (operator.matches("\\/")) {
            optype = "Div";
        }

        return optype;
    }

}
