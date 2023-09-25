import edu.princeton.cs.algs4.*;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000000;

    public static double timeTrial(int n) {
        Int op = new Int("42");
        Int[] a = new Int[n];
        for (int i = 0; i < n; i++) {
            a[i] =new Int(StdRandom.uniform(100000000, MAXIMUM_INTEGER));
        }
        Stopwatch timer = new Stopwatch();

        for (int i = 0; i < n; i++) {
            a[i].multiply(op);
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

