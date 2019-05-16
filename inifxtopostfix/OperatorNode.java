package inifxtopostfix;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpendyam
 */
public class OperatorNode implements Node{
    Node left,right;
    Operator operator;
    
    public OperatorNode(Operator operator, Node left,
                        Node right){
        this.left=left;
        this.right = right;
        this.operator=operator;
    }
    
    public double evaluate(){
       double leftValue = left.evaluate();
       double rightValue = right.evaluate();
       return operator.evaluate(leftValue,rightValue);
    }
    
    public String preOrderWalk(){
        String leftValue = left.preOrderWalk();
        String rightValue = right.preOrderWalk();
         
        return "" + operator + " " + leftValue + " "+ rightValue;
    }
    
    public String inOrderWalk(){
        String leftValue = left.inOrderWalk();
        String rightValue = right.inOrderWalk();
         
        return "" + leftValue + " " + operator + " "+ rightValue;
    }
    
        
    public String postOrderWalk(){
        String leftValue = left.postOrderWalk();
        String rightValue = right.postOrderWalk();
         
        return "" + leftValue + " " + rightValue + " "+ operator;
    }
    
}
