/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

/**
 *
 * @author vpendyam
 */
public class Sequence {

    private static int efficiency = 0;

    public static int computeIterative(int a, int b) {
        efficiency = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int result = 0;
        while (b > 0 && a % b > 0) {
            efficiency++;

            if (b > 0) {
                c = a % b;
            }
            if (c == 0) {
                result = b;
            }
            d = b;
            if (c > 0) {
                e = d % c;
            }
            if (e == 0) {
                result = c;
            }

            b = e;
            a = c;
      System.out.println("Iterative " + efficiency + " Iteration  value of a:" + a + " b:" + b);
    
        }
      return result;

    }

    public static int computeRecursive(int a, int b) {
        efficiency++;
        if (b == 0) {
            return a;
        } else if (a >= b && b > 0) {
            return computeRecursive(b, (a % b));
        }
        System.out.println("Recursive " + efficiency + "Iteration  value of a:" + a + " b:" + b);
        return computeRecursive(b, (a % b));
    }

    public static int getEfficiency() {
        return efficiency;
    }
    

}
