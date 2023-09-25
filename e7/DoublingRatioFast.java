import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class DoublingRatioFast {
    private static final int MAXIMUM_INTEGER = 1000000;


    /**
     * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
     * random 6-digit integers.
     * @param n the number of integers
     * @return amount of time (in seconds) to call {@code ThreeSum.count()}
     *   with <em>n</em> random 6-digit integers
     */
    public static double timeTrial(int n) {
        int[] a = new int[n];
        int[] b = new int[n];
        int[] arr_def = null;
        Queue<Integer> queue_a = new Queue<Integer>();
        Queue<Integer> queue_b = new Queue<Integer>();
        Queue<Integer> def = new Queue<Integer>();
        int sig = 0;
        int count_a = 0;
        int count_b = 0;
        int m = 0;

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
            b[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Stopwatch timer = new Stopwatch();

        for(int i = 0; i < a.length-1; i++){
            if(sig < a.length){sig += 1;}
            if(a[i] != a[sig]){
                queue_a.enqueue(a[i]);
                count_a += 1;
            }

            if(b[i] != b[sig]){
                queue_b.enqueue(b[i]);
                count_b += 1;
            }
            if(sig == a.length-1){
                queue_a.enqueue(a[sig]);
                queue_b.enqueue(b[sig]);
                count_a += 1;
                count_b += 1;
            }
        }

        m = count_a + count_b;
        arr_def = new int[m];
        for(int i = 0; i < arr_def.length; i++){
            if(i < count_a){arr_def[i] = queue_a.dequeue();}
            else{arr_def[i] = queue_b.dequeue();}
        }

        sig = 0;
        Arrays.sort(arr_def);
        for(int i = 0; i < arr_def.length-1; i++){
            if(sig < arr_def.length){sig += 1;}
            if(arr_def[i] == arr_def[sig]){def.enqueue(arr_def[i]);}
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
