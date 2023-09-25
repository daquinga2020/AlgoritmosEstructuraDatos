package ayedd.e7;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Iterator;

public class Interseccion{

    public static void main(String[] args){
        In in1 = new In(args[0]);
        In in2 = new In(args[1]);
        int[] a = in1.readAllInts();
        int[] b = in2.readAllInts();

        int[] conj = new int[a.length+b.length];
        int[] conj_rep = null;
        Queue<Integer> queue = new Queue<Integer>();
        int count = 0;
        int dob = 0;
        
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

        Iterator<Integer> it = queue.iterator();
        while(it.hasNext()){
            StdOut.println(it.next());
        }
    }
}
