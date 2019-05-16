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
public class OperandNode implements Node {

    private double value;

    public OperandNode(double value) {
        this.value = value;

    }

    public double evaluate() {
        return value;
    }

    public String preOrderWalk() {
        return String.valueOf(value);
    }

    public String inOrderWalk() {
        return String.valueOf(value);
    }

    public String postOrderWalk() {
        return String.valueOf(value);
    }

}
