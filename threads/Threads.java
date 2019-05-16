 /* File: Threads.java
 * Author: Vikram Pendyam
 * Date: Apr 04, 2019
 * Purpose: 
 * This is main method where thread is began
 */
package threads;

public class Threads {

    public static void main(String[] args) {

        Multithread t1 = new Multithread(1);
        t1.start();//starting the first thread and putting it to sleep inorder to execute sequential
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Invalid thread");
        }//Technically no exception should be raised
        Multithread t2 = new Multithread(2);
        t2.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Invalid thread");
        }//Technically no exception should be raised
        Multithread t3 = new Multithread(3);
        t3.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Invalid thread");
        }//Technically no exception should be raised

    }

}
