 /* File: InfixEvaluator.java
 * Author: Vikram Pendyam
 * Date: Mar 27, 2019
 * Purpose: 
 * This class takes care if inflix to postfix convertion
 */
package stacksweek1;

import java.util.*;
import java.util.regex.Pattern;

public class InfixEvaluator {

    //variables
    Stack<String> operandStack = new Stack<>();
    Stack<String> operatorStack = new Stack<>();

    //convert the infix into list
    private List<String> tokenizer(String infix) {
        //list variable
        List<String> tokens = new ArrayList<>();
        //remove leading and trailing spaces
        infix = infix.trim();
        tokens.add(Character.toString(infix.charAt(0)));
        for (int i = 1; i < infix.length(); i++) {
            char c = infix.charAt(i);
            char lastc = infix.charAt(i - 1);
            //if there is any space lets not add and just continue
            if (c == ' ') {
                continue;
            }
            //what is previous is also digit
            if (Character.isDigit(c) && Character.isDigit(lastc)) {
                tokens.set((tokens.size() - 1), tokens.get(tokens.size() - 1) + c);
            } else {
                tokens.add(Character.toString(c));
            }
        }
        return tokens;
    }
//converts inflix to postfix operation
    // throw DivideByZero exception

    String getResult(String exps) throws DivideByZero, EmptyStackException, IllegalAccessException {

       
        List<String> hasmoretokens = tokenizer(exps);//tokenizing into list

        for (String nexttoken : hasmoretokens) {
            Pattern isOperator = Pattern.compile("[*/+\\-]"); //identifying the operators
            Pattern isOperand = Pattern.compile("[\\d.?]+"); //identifying the operands
            
            //checking invalid expression , considering only +,-,*,/,(,)
            if (!nexttoken.equals("(") && !nexttoken.equals(")") && !nexttoken.equals("+") && !nexttoken.equals("-")
                    && !nexttoken.equals("*") && !nexttoken.equals("/") && !nexttoken.matches(String.valueOf(isOperand))) {
                throw new IllegalAccessException("Invalid expression");
            }
            //if this is an operand
            if (nexttoken.matches(String.valueOf(isOperand))) {
                operandStack.push(nexttoken);

            } else if (nexttoken.equals("(")) {
                operatorStack.push(nexttoken);

            } else if (nexttoken.equals(")")) {

                while (!operatorStack.peek().equals("(")) {
                    String value1 = operandStack.pop();
                    String value2 = operandStack.pop();
                    //Swapping the values, when you pop out 
                    operandStack.push(performOp(operatorStack.pop(), value2, value1));

                }
                operatorStack.pop();
            } else if (nexttoken.matches(String.valueOf(isOperator))) {//if this is an operator

                while (!operatorStack.empty() && hasPrecedence(operatorStack.peek()) >= hasPrecedence(nexttoken)) {
                    String value1 = operandStack.pop();
                    String value2 = operandStack.pop();
                    operandStack.push(performOp(operatorStack.pop(), value2, value1));

                }
                //push the current operator into the stack
                operatorStack.push(nexttoken);
            }

        }
        while (!operatorStack.empty()) {
            String value1 = operandStack.pop();
            String value2 = operandStack.pop();

            operandStack.push(performOp(operatorStack.pop(), value2, value1));
        }
        //final result value
        return operandStack.pop();

    }

    //this method does arithematic operation
    String performOp(String operation, String op1, String op2) throws DivideByZero {
        int result = 0;
        int value1 = Integer.parseInt(op1);//converts string to integer
        int value2 = Integer.parseInt(op2);

        switch (operation) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                if (value2 == 0) {
                    throw new DivideByZero("Cannot be divided by Zero");
                }
                result = value1 / value2;

                break;
        }
        return Integer.toString(result);

    }

//Applying BODMAS rule
    private int hasPrecedence(String i) {
        if (i.equals("-") || i.equals("+")) {
            return 1;
        }
        if (i.equals("*") || i.equals("/")) {
            return 2;
        }
        return 0;
    }

}
