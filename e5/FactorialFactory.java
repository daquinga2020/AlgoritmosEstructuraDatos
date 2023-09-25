package ayedd.e5;
import edu.princeton.cs.algs4.*;
import java.util.Iterator;
import java.lang.Iterable;

public class FactorialFactory
{
    private boolean answ;
    public static FactorialSet almacen = new FactorialSet();

    public FactorialFactory(boolean isMemo) { answ = isMemo; }

    public Int factorial(Int n)
    {
        Iterator<Int> mem_fact = null;
        Int cop_n = new Int(n);
        Int cop_n2 = new Int(n);
        Int acum = new Int("1");
        Int sub_1 = new Int("1");
        Int fact = null;
        int out = 0;
        cop_n.minus();
        cop_n2.plus(cop_n);

        if (answ == true)
        {
            if(almacen.top() == null){ almacen.add(sub_1); }
            if(!n.lessThan(almacen.top()))
            {
                fact = almacen.top();
                while(fact.lessThan(n)){
                    fact.plus(sub_1);
                    acum.multiply(fact);
                    almacen.add(acum);
                }
            }

            fact = almacen.top();
            if(n.lessThan(fact)){
                mem_fact = almacen.iterator(n, n);
                acum = mem_fact.next();
            }
        }
        else
        {
            if(n.toString().equals("1")){out = 1;}
            else if(n.toString().equals("0")){
                out = 1;
                cop_n2 = new Int("1");
            }

            while(out == 0){
                cop_n2.plus(sub_1);
                acum.multiply(cop_n2);
                if(cop_n2.toString().equals(n.toString())){ out = 1; }
            }
        }
        return acum;
    }

    public Iterator<Int> factorial(Int m, Int n)
    {
        Queue<Int> queue = new Queue<Int>();
        Iterator<Int> it = null;
        FactorialFactory ft_temp = new FactorialFactory(false);
        Int big = new Int(n);
        Int small = new Int(m);
        Int sub_1 = new Int("1");
        String str_small = small.toString();
        int out = 0;
        int first_m = 0;
        
        if(n.lessThan(m)){
            big = new Int(m);
            small = new Int(n);
            first_m = 1;
            sub_1.minus();
            small.plus(sub_1);
            str_small = small.toString();
        }
        String str_big = big.toString();

        if (answ == false)
        {   
            while(out == 0)
            {
                if(first_m == 0){
                    queue.enqueue(ft_temp.factorial(small));
                    small.plus(sub_1);
                    str_small = small.toString();
                    if(str_small.equals(str_big)) { out = 1; queue.enqueue(ft_temp.factorial(small)); }
                }
                else{
                    queue.enqueue(ft_temp.factorial(big));
                    big.plus(sub_1);
                    str_big = big.toString();
                    if(str_big.equals(str_small)) { out = 1; }
                }
            }
            it = queue.iterator();
        }
        else { it = almacen.iterator(m,n); }
        return it;
    }

    public static void main(String[] args)
    {
        FactorialFactory ft = new FactorialFactory(true);
        Int n1 = new Int("3553");
        Int n2 = ft.factorial(n1);

        Iterator<Int> it_Int = ft.factorial(new Int(args[0]), new Int(args[1]));
        while(it_Int.hasNext()){
            StdOut.println(it_Int.next().toString());
        }
    }
}