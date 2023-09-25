import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class DoublingTestFast {
    private static final int MAXIMUM_INTEGER = 1000000000;

    public static double timeTrial(int n) {
        int[] a = new int[n];
        int sig = 0;
        int count = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Arrays.sort(a);
        Stopwatch timer = new Stopwatch();

        for(int i = 0; i < a.length-1; i++){
            if(sig < a.length){sig += 1;}
            if(a[i] == a[sig]){count+=1;}
            else{count = 0;}
            sum = sum + count;
        }
        
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int n = 32000; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.11f\n", n, time);
        }
    } 
}

