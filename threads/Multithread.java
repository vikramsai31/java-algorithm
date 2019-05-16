 /* File: Threads.java
 * Author: Vikram Pendyam
 * Date: Apr 04, 2019
 * Purpose: 
 * This demo method extends the thread and overides the run method with required output
 */
package threads;

/**
 *
 * @author vpendyam
 */
public class Multithread extends Thread {

    private int thread_id;

    public Multithread(int tid) {
        this.thread_id = tid;//passing in the thread ID

    }

    public void run() {//run method overide

        synchronized (this) {
            for (int i = 1; i <= 5; i++) {//Iterates 5 times
                System.out.println("Thread "
                        + thread_id
                        + "  - iteration no - " + i);//Displaying required output
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Invalid thread");
                    break;
                }

            }
        }

    }

}
