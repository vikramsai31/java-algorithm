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
public interface Node {
    public double evaluate();
    public String preOrderWalk();
    public String inOrderWalk();
    public String postOrderWalk();
   
}
