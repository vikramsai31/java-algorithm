/**
 * Filename: DeadLockSafe.java Author: vikram Pendyam Date: 04/08/2019
 * Description: Matrix.txt file is passed as input parameter. It used
 * backtracking to find the best solution for safest path of process execution
 * avoiding the deadlock
 */
package bankersalgorithm;

/**
 *
 * @author vpendyam
 */
public class DeadLockSafe {

    private int[][] alloc;
    private int[][] max;
    private static int[] avail;
    private int p;
    private int r;

    public DeadLockSafe(int[][] alloc, int[][] max, int[] avail, int p, int r) {
        this.alloc = alloc;//currently allocated resources
        this.max = max;//max resource
        this.avail = avail;//available resources
        this.p = p;//processes
        this.r = r;//resources

    }

    /*
    Calclating the need matrix. Return 2D matrix
    */
    public int[][] getNeed() {
        int[][] need = new int[this.p][this.r];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }
        return need;
    }

    /*
    Produces safest sequence by backtracking
    */
    public void safeSequence() {
        int[][] need = getNeed();
        int[] path = new int[p];
        int[] f = new int[p];
        int inc = 0;
        for (int k = 0; k < p; k++) {
            f[k] = 0;
        }

        for (int k = 0; k < p; k++) {

            for (int i = 0; i < p; i++) {
                if (f[i] == 0) {
                    int flag = 0;

                    for (int j = 0; j < r; j++) {
                        if (need[i][j] > avail[j]) {
                            flag = 1;
                        }
                        break;
                    }

                    if (flag == 0) {

                        path[inc++] = i;
                        for (int y = 0; y < r; y++) {
                            avail[y] += alloc[i][y];
                        }
                        f[i] = 1;

                    }

                }
            }

        }

        System.out.println("****SAFE Sequence Using Backtracking ****");
        for (int i = 0; i <= p - 1; i++) {
            if (i == p - 1) {
                System.out.print("P" + path[i]);
            } else {
                System.out.print("P" + path[i] + "->");
            }
        }
        System.out.println(" ");

    }

}
