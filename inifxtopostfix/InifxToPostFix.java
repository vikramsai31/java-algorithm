/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inifxtopostfix;

/**
 *
 * @author vpendyam
 */
public class InifxToPostFix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tree for 2 + 3 - 1
   Node tree;
        tree = new OperatorNode(new SubOperator(),new OperatorNode(new AddOperator(),
                new OperandNode(2),new OperandNode(3)),new OperandNode(1));
    System.out.println("Value is " + tree.evaluate());
    System.out.println(tree.preOrderWalk());
    System.out.println(tree.inOrderWalk());
    System.out.println(tree.postOrderWalk());
    }
    
}
