package ayedd.e2;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class Separador{
    
    public static int[] separa(int[] nums){
        int comp = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if (nums[i] <= nums[j]){
                    comp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = comp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args){
        try{
            int[] values = StdIn.readAllInts();
            values = separa(values);
            StdOut.println(Arrays.toString(values));
        }
        catch (java.lang.NumberFormatException e){
            System.err.println("No son validos los valores introducidos.");
            System.exit(1);
        }
    }
}
