package ayedd.examenFinal;
import edu.princeton.cs.algs4.*;

public class Vector{

    private int[] cop;

    public Vector(int[] elems){

        cop = new int[elems.length];

        for(int i = 0; i < elems.length; i++){
            cop[i] = elems[i];
        }
    }

    public int scalarProduct(Vector v){

        if(this == null || v == null){return 0;}
        else if(this.cop.length != v.cop.length){return 0;}
        else{
            int resul = 0;
            
            for(int i = 0; i < this.cop.length; i++){
                resul = resul + (this.cop[i] * v.cop[i]);
            }
            return resul;
        }
    }
    public String toString(){
        String str_v = "{";

        for(int i = 0; i < cop.length; i++){
            str_v = str_v + Integer.toString(cop[i]);
            if(i != cop.length - 1){
                str_v = str_v + ",";
            }
        }
        return str_v + "}";
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3};
        int[] arr2 = {1,1,1};
        Vector v1 = new Vector(arr);
        Vector v2 = new Vector(arr2);
        StdOut.println(v1.toString());

        Vector v3 = null; 

        StdOut.println(v1.scalarProduct(v3));
    }
}