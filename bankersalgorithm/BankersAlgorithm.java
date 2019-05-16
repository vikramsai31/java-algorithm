/**
 * Filename: BankerAlogorithhm.java Author: vikram Pendyam Date: 04/08/2019
 * Description: Matrix.txt file is passed as input parameter. It used
 * backtracking to find the best solution for safest path of process execution
 * avoiding the deadlock
 */
package bankersalgorithm;

import java.io.*;
import java.util.*;

public class BankersAlgorithm {

    /**
     * @param r = Available resources
     * @param p = Available processes
     * @param alloc = Allocated processes for resources
     * @param avail = Total available resources
     * @param Max = max resources
     */
    public static void main(String[] args) throws IOException {

        int r = 0;
        int p = 0;
        int count = 0;
        String fileIn;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the file : ");//pass the file name
        fileIn = keyboard.nextLine();
        FileReader fr = new FileReader(fileIn);
        BufferedReader bufRead = new BufferedReader(fr);//keeping the contents of the file in the buffer
        String line = bufRead.readLine();
        p = Integer.parseInt(line);
        count++;

        line = bufRead.readLine();
        r = Integer.parseInt(line);
        count++;

        int[][] alloc = new int[p][r];
        int[][] max = new int[p][r];
        int[] avail = new int[r];

        line = bufRead.readLine();
        count++;
        int linecount = 0;
        while (line != null && linecount < p) {
            StringTokenizer tokens = new StringTokenizer(line);
            if (tokens.hasMoreTokens()) {
                for (int j = 0; j < r; j++) {
                    alloc[linecount][j] = Integer.parseInt(tokens.nextToken());//building allocated resource matrix
                }

            }
            line = bufRead.readLine();
            linecount++;
            count++;
        }

        linecount = 0;
        while (line != null && linecount < p) {
            StringTokenizer tokens = new StringTokenizer(line);
            if (tokens.hasMoreTokens()) {
                for (int j = 0; j < r; j++) {
                    max[linecount][j] = Integer.parseInt(tokens.nextToken());//building max resource matrix
                }

            }
            line = bufRead.readLine();
            linecount++;
            count++;
        }

        StringTokenizer tokens = new StringTokenizer(line);//reading the last line
        while (tokens.hasMoreTokens()) {
            for (int i = 0; i < r; i++) {
                avail[i] = Integer.parseInt(tokens.nextToken());//total available resources
            }
        }

        bufRead.close();//close the buffer reade
        fr.close();

        System.out.println("***Display Alloc Matrix***");//display matrix  loaded  allocated values
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(alloc[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("***Display Max Matrix***");//display matrix  loaded  max values
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(max[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("***Display Available Resource***");//display matrix  loaded  available values
        for (int i = 0; i < r; i++) {
            System.out.print(avail[i] + " ");
        }
        System.out.println("");
        DeadLockSafe d = new DeadLockSafe(alloc, max, avail, p, r);//Producing the safest path
        d.safeSequence();

    }

}
