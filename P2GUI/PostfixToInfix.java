/**
 * Filename: PostfixToInfix.java 
 * Author: vikram Pendyam 
 * Date: 04/08/2019
 * Description: Converts and postfix expression to an infix expression using
 * binary tree nodes
 */
package P2GUI;

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class PostfixToInfix {
    /*
     @param creates pistack for using stacks
     */

    Stack<Node> piStack = new Stack<>();
    private Node operator;

    /*
     @param : String expression. Accepts String expression to convert postfix to infix expression
     This method also throws few exceptions   
     */
    public String evaluate(String expression) throws InvalidExpression, EmptyStackException, IOException {

        /**
         * lets tokenize the input string*
         */
        List<String> tokens = tokenizer(expression);

        for (String nxtToken : tokens) {
            /**
             * Regex to check the operator and operand check
             *
             */
            Pattern chkOperand = Pattern.compile("[\\d.?]+");
            Pattern chkOperator = Pattern.compile("[*/+\\-]");

            /*
             * Raise exception incase invalid token
             */
            if (!nxtToken.equals("(") && !nxtToken.equals(")") && !nxtToken.matches(String.valueOf(chkOperator))
                    && !nxtToken.matches(String.valueOf(chkOperand))) {
                throw new InvalidExpression("Invalid Token " + nxtToken);
            }
            /*
             * Checking if the token is operand or operator
             */
            if (nxtToken.matches(String.valueOf(chkOperand))) {
                piStack.push(new OperandNode(nxtToken));
                System.out.println("pistack operands : " + piStack.peek().inOrderWalk());//just for debugging
            } else if (nxtToken.matches(String.valueOf(chkOperator))) {
                Node rexpr = piStack.pop();
                Node lexpr = piStack.pop();
                operator = new OperatorNode(nxtToken, lexpr, rexpr);
                //operator = new OperatorNode(nxtToken, piStack.pop(), piStack.pop());
                piStack.push(operator);
                System.out.println("pistack operators : " + piStack.peek().inOrderWalk());//just for debugging
            }
           

        }
        /*
         *Return the string value with full expression
         */
        operator.PostOrderWalk();
        //writeToFile(operator.PostOrderWalk());
        
        return piStack.pop().inOrderWalk();
    }
/**
         * Private method for tokenizing the post fix expression
         */
    private List<String> tokenizer(String postfix) {
        List<String> tokens = new ArrayList<String>();//combined full token

        postfix = postfix.trim();//Trimming the spaces
        char c = postfix.charAt(0); //setting the first value
        tokens.add(Character.toString(c));

        for (int i = 1; i < postfix.length(); i++) {
            c = postfix.charAt(i);
            char lastc = postfix.charAt(i - 1);
            if (c == ' ') {
                continue;//continue is there are any spaces
            }

            if (Character.isDigit(c) && Character.isDigit(lastc)) {
                tokens.set(tokens.size() - 1, tokens.get((tokens.size() - 1)) + c);//Merging digits if its more than one
            } else {
                tokens.add(Character.toString(c));
            }

        }
        /*
        *return list of tokens
        */
        return tokens;
    }
/*
    * Created this method for closing brackets. According to the output from GUI we need brackets for every expression
    *so I'm not really using this method any where but just keeping it around in case needed.
    */
    public boolean operatorExist(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                return true;
            }
        }
        return false;
    }
   

}
