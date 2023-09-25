package ayedd.e5;
import edu.princeton.cs.algs4.*;
import java.util.Iterator;
import java.lang.Iterable;

public class FactorialSet
{
    private Int[] factoriales;
    private int indice = 1;
    
    public FactorialSet()
    {
        factoriales = new Int[4];
    }

    public void add(Int f)
    {
        if(indice == factoriales.length){ resize(factoriales.length*2); }
        if(this.top() == null) { factoriales[0] = new Int(f); }
        else{   
            factoriales[indice] = new Int(f);
            indice += 1;
        }
    }

    public Int top()
    {
        Int a = null;
        int vacio = 0;
        int last = indice;

        for (int i = 0; i < factoriales.length; i++) { if(factoriales[i] == null){ vacio += 1; } }
        if(vacio == factoriales.length){a = null;}
        else{
            last -= 1;
            a = new Int(last);
        }
        return a;
    }

    public Iterator<Int> iterator(Int m, Int n)
    {
        Iterator<Int> it = null;
        Queue<Int> queue = new Queue<Int>();
        Int big = new Int(n);
        Int small = new Int(m);
        int first_m = 0;
        
        if(n.lessThan(m)){
            big = new Int(m);
            small = new Int(n);
            first_m = 1;
        }
        int ind_max = Integer.parseInt(big.toString());

        if(first_m == 0){
            for(int ind_min = Integer.parseInt(small.toString()); ind_min <= ind_max; ind_min++){
                queue.enqueue(factoriales[ind_min]);
            }
        }
        else{
            for(int ind_min = Integer.parseInt(small.toString()); ind_min <= ind_max; ind_max--){
                queue.enqueue(factoriales[ind_max]);
            }
        }

        it = queue.iterator();

        return it;
    }

    private void resize(int max)
    {
        // Movemos pila de tamaño n <= max a nuevo array de tamaño max
        Int[] temp = (Int[]) new Int[max];
        for (int i = 0; i < indice; i++) { temp[i] = factoriales[i]; }
        factoriales = temp;
        
    }

    public static void main(String[] args)
    {
        FactorialSet f = new FactorialSet();
        Int l = new Int("1");
        f.add(l);
        
        Int l1 = new Int("1");
        f.add(l1);
        
        Int l2 = new Int("2");
        f.add(l2);
        
        Int l3 = new Int("6");
        f.add(l3);

        Int l4 = new Int("24");
        f.add(l4);

        Int l5 = new Int("120");
        f.add(l5);

        Int l6 = new Int("720");
        f.add(l6);

        Int l7 = new Int("5040");
        f.add(l7);

        Int l8 = new Int("40320");
        f.add(l8);

        Int l9 = new Int("362880");
        f.add(l9);
        Int n = f.top();
        StdOut.println(n.toString());

        Iterator<Int> it_Fact = f.iterator(new Int("0"), new Int("9"));
        while(it_Fact.hasNext())
        {
            StdOut.println(it_Fact.next().toString());
        }
    }
}