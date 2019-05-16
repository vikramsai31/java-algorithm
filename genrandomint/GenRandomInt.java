/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genrandomint;
/*
 * File: GenRandomInt.java
 * Author: Vikram Pendyam
 * Date: Oct 24, 2018
 * Purpose: This program generates
 * x number of random integers between 0 and y
 * Usage: java GenRandomInt 10 1000
 */

public class GenRandomInt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // minimum integer will always be 0
        int minInt = 0;
        //max integer value
        int maxInteger = 100;
        //total random values required
        int totalInteger = 10;

        // Check to make sure we have command line argument
        if (args.length == 2) {
            maxInteger = Integer.parseInt(args[1]);    
            totalInteger = Integer.parseInt(args[0]); 
            System.out.println("Generating: "
                    + totalInteger + " Random Integers between "+ minInt + " and "+ maxInteger);
        } else {
            System.out.println("Application requires 2 command arguments");
            System.out.println("e.g. java GenRandomInt 10 1000");
            System.exit(0);
        }
        for (int i=0 ; i<totalInteger; i++){
            //using random method from math function
            int randInt = (int) (Math.random() * maxInteger);
            System.out.println("Random Int is " + randInt);
        }
    }

}
