import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class DoublingRatio {
    private static final int MAXIMUM_INTEGER = 1000000000;


    /**
     * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
     * random 6-digit integers.
     * @param n the number of integers
     * @return amount of time (in seconds) to call {@code ThreeSum.count()}
     *   with <em>n</em> random 6-digit integers
     */
    public static double timeTrial(int n) {
        int[] a = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();

        for(int i = 0; i < a.length; i++){
            for(int j = 1 + i; j < a.length; j++){
                if(a[i] == a[j]){count+=1;}
            }
        }
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth, along
     * with ratios of running times between successive array sizes.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) { 
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.11f %5.11f\n", n, time, time/prev);
            prev = time;
        } 
    } 
} 


