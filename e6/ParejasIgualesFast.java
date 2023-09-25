package ayedd.e6;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ParejasIgualesFast{

    public static void main(String[] args){
        In in1 = new In(args[0]);
        int[] a = in1.readAllInts();
        Arrays.sort(a);
        int sig = 0;
        int count = 0;
        int sum = 0;
        for(int i = 0; i < a.length-1; i++){
            if(sig < a.length){sig += 1;}
            if(a[i] == a[sig]){count+=1;}
            else{count = 0;}
            sum = sum + count;
        }
        StdOut.println(sum);
    }
}