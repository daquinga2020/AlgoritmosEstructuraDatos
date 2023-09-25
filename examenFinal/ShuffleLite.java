package ayedd.examenFinal;
import edu.princeton.cs.algs4.*;

public class ShuffleLite<Item>{

    private Node first;
    private int n = 0;

    private class Node
    {
	    Item item;
	    Node next;
    }

    public void add(Item item)
    { 
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
	    n++;
    }

    public void shuffle(int n){
        //Aun por implementar
    }

    public String toString(){
        String str_b = "]";
        int max = n;
        for(Node x = first; x != null; x = x.next){
            str_b = x.item + str_b;
            max -= 1;
            if(max != 0){
                str_b = "," + str_b;
            }
        }

        return  "[" + str_b;
    }

    public static void main(String[] args){
        ShuffleLite<Integer> a = new ShuffleLite<Integer>();
        int n1 = 0;
        for(int i = 0; i < 4; i++){
            a.add(i);
        }

        String str = a.toString();
        StdOut.println(str);
    }
}