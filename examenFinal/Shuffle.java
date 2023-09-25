package ayedd.examenFinal;
import edu.princeton.cs.algs4.*;

public class Shuffle<Item>{

    private Queue<Item> baraja;
    private Queue<Item> izq_brj = new Queue<Item>();
    private Queue<Item> der_brj = new Queue<Item>();

    public Shuffle(){
        baraja = new Queue<Item>();
    }

    public void add(Item item)
    {
        baraja.enqueue(item);
    }

    public void shuffle(int n){
        if(baraja != null){
        if(n > 0){
            int max = baraja.size();
            int mid = 0;
            if(max%2 == 0){mid = (baraja.size()/2) - 1;}
            else{mid = baraja.size()/2;}
            for(int i = 0; i < n; i++){
                int lo = 0;
                for(Item elem: baraja){
                    if(lo <= mid){
                        izq_brj.enqueue(elem);
                        lo += 1;
                    }
                    else{ der_brj.enqueue(elem); }
                    baraja.dequeue();
                }
                for(int j = 0; j < max; j++){
                    if(j%2 == 0){baraja.enqueue(izq_brj.dequeue());}
                    else{baraja.enqueue(der_brj.dequeue());}
                }
            }
        }
        }
    }

    public String toString(){
        String str_b = "[";
        int max = baraja.size();
        for(Item i: baraja){
            str_b = str_b + i;
            max -= 1;
            if(max != 0){
                str_b = str_b + ",";
            }
        }

        return str_b + "]";
    }

    public static void main(String[] args)
    {
        Shuffle<Integer> a = new Shuffle<Integer>();
        int n1 = 0;
        for(int i = 0; i < 4; i++){
            a.add(i);
        }
        a.shuffle(1);
        String str = a.toString();
        StdOut.println(str);

        Shuffle<Integer> b = new Shuffle<Integer>();
        b.shuffle(5);
        StdOut.println(b.toString());
    }
}