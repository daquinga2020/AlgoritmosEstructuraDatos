import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000000;

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

    public static void main(String[] args) {
        for (int n = 32000; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.11f\n", n, time);
        }
    } 
}

