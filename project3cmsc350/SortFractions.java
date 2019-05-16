/**
 * Filename: SortFractions.java 
 * Author: vikram Pendyam 
 * Date: 04/18/2019
 * Description: Implements comparable and sorts fractions accepting string
 * format
 * 
*/
package project3cmsc350;

import java.util.*;
import java.text.DecimalFormat;
/*
@args: numerator, denominator, sol
all args achived from splitting the array using regex
*/

public class SortFractions implements Comparable<SortFractions> {

    private double numerator; 
    private double denominator;
    private double sol;

    //split fraction into array and separate into numerator and denominator
    public SortFractions(String fraction) {
        String[] fArray = fraction.split("/");
        numerator = Integer.parseInt(fArray[0]);
        denominator = Integer.parseInt(fArray[1]);
        this.sol = numerator / denominator;       
    }
    
    //getter values for comparable
    private double getSol(){
        return this.sol;
    }
    
    @Override
    //tostring method
    public String toString(){  
        //return decimal format
        DecimalFormat df = new DecimalFormat();
        return df.format(numerator)+"/"+ df.format(denominator);
    }

    @Override
    //compareTo method for sorting
    public int compareTo(SortFractions frac) {
        if( this.sol == frac.getSol()){
            return 0;
        } else if (this.sol > frac.getSol()){
            return 1;
        }else {
            return -1;
        }

    }

}
