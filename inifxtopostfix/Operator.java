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
public abstract class Operator {

    abstract public double evaluate(double x, double y);

}

class AddOperator extends Operator {

    public double evaluate(double d1, double d2) {
        return d1 + d2;
    }

    public String toString() {
        return "+";
    }
}

class SubOperator extends Operator {

    public double evaluate(double d1, double d2) {
        return d1 - d2;
    }

    public String toString() {
        return "-";
    }
}

class DivisionOperator extends Operator {

    public double evaluate(double d1, double d2) {
        return d1 / d2;
    }

    public String toString() {
        return "/";
    }
}

class MultOperator extends Operator {

    public double evaluate(double d1, double d2) {
        return d1 * d2;
    }

    public String toString() {
        return "*";
    }
}
