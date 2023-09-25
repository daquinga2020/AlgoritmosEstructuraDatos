package ayedd.E1;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class SumaEnterosArray {
    public static int Comprobation(int[] op1, int[] val){
        int control = 0;

        for (int i = 0; i < val.length; i++){
            for (int j = 0; j < op1.length; j++){
                if (op1[j] == val[i]){
                    control += 1;
                }
            }
        }
        return control;
    }

    public static int Size_Array(int long1, int long2){
        if (long1 >= long2){
            return long1;
        }
        else{
            return long2;
        }
    }

    public static int[] suma (int[] oper1, int[] oper2){
        int size = Size_Array(oper1.length, oper2.length);
        int[] resul = new int[size];
        int dif = 0;
        int oper_men;

        if (oper1.length <= oper2.length){
            oper_men = oper1.length;
        }
        else{
            oper_men = oper2.length;
        }
        for (int i = 0; i < oper_men; i++){
            if (oper1.length == oper2.length){
                resul[i] = oper1[i] + oper2[i];
                }
            else if(oper1.length > oper2.length){
                dif = oper1.length - oper2.length;
                for (int n = 0; n < dif; n++){
                    resul[n] = oper1[n];
                    }
                resul[i + dif] = oper1[i + dif] + oper2[i];
            }
            else{
                dif = oper2.length - oper1.length;
                for (int n = 0; n < dif; n++){
                    resul[n] = oper2[n];
                    }
                resul[i + dif] = oper2[i + dif] + oper1[i];
            }
        }
        int resul_ampl = 0;
        int ind_resul = resul.length - 1;
        int[] def_resul = new int[size + 1];
        while(ind_resul > -1){
            if(resul[ind_resul] >= 10){
                resul[ind_resul] = resul[ind_resul] - 10;
                if(ind_resul != 0 ){
                    resul[ind_resul-1] += 1;
                }
                else{
                    def_resul[0] += 1;
                    for (int i = 0; i < resul.length; i++){
                        def_resul[i+1] = resul[i];
                    }
                    resul_ampl = 1;
                }
            }
            ind_resul -= 1;
        }
        if(resul_ampl == 1){
            return def_resul;
        }
        else{
            return resul;
        }
    }

    public static void main (String[] args){

        In in1 = new In(args[0]);
        In in2 = new In(args[1]);
        int[] s1 = in1.readAllInts();
        int[] s2 = in2.readAllInts();
        int[] valid_values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int ctrl1 = Comprobation(s1, valid_values);
        int ctrl2 = Comprobation(s2, valid_values);

        if (ctrl1 == s1.length && ctrl2 == s2.length){
            int[] resultado = suma(s1,s2);
            StdOut.println(Arrays.toString(resultado));
        }
        else {
            System.err.println("Error: los operadores no son válidos.");
            System.exit(1);
        }
    }
}