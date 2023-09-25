package ayedd.e6;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ParejasIguales{

    public static void main(String[] args){
        In in1 = new In(args[0]);
        int[] a = in1.readAllInts();
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 1 + i; j < a.length; j++){
                if(a[i] == a[j]){count+=1;}
            }
        }
        StdOut.println(count);
    }
}