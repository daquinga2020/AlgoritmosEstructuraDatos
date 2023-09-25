import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000000;

    public static double timeTrial(int n) {
        int[] a = new int[n];
        int[] b = new int[n];

        int[] conj = new int[a.length+b.length];
        int[] conj_rep = null;
        Queue<Integer> queue = new Queue<Integer>();
        int man = 0;
        int count = 0;
        int dob = 0;

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
            b[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(a[i] == b[j]){
                    conj[dob] = a[i];
                    dob +=1;
                }
            }
        }
        
        conj_rep = new int[dob];
        for(int i = 0; i < conj_rep.length; i++){
            conj_rep[i] = conj[i];
        }

        for(int i = 0; i < conj_rep.length; i++){
            for(int j = i+1; j < conj_rep.length; j++){
                if(conj_rep[i] == conj_rep[j]){count = 1;}
            }
            if(count == 0){
                queue.enqueue(conj_rep[i]);
            }
            count = 0;
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

