package ayedd.e5;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Iterator;

public class Int 
{
    private String str_int;
    private int[] num;
    private int signo = 1;
    
    public Int(int i)
    {   
        str_int = Integer.toString(i);
        int ind_word = 1;
        if(str_int.charAt(0) == '-')
        {
            signo = -1;
            String new_str_int = str_int.substring(1, str_int.length());
            num = new int[new_str_int.length()];
            for (int j = 0; j < new_str_int.length(); j++ )
            {
                String num_word = new_str_int.substring(j, ind_word);
                int value = Integer.parseInt(num_word);
                num[j] = value * signo;
                ind_word += 1;
            }
        }
        else
        {
            num = new int[str_int.length()];
            for (int j = 0; j < str_int.length(); j++ )
            {
                String num_word = str_int.substring(j, ind_word);
                int value = Integer.parseInt(num_word);
                num[j] = value * signo;
                ind_word += 1;
            }
        }
        num = out_zeros(num);
    }
    
    public Int(Int i)
    {
        str_int = i.str_int;
        num = new int[i.num.length];
        int[] n = new int[i.num.length];
        for (int j = 0; j < i.num.length; j++)
        { n[j] = i.num[j]; }
        num = n;
        num = out_zeros(num);
    }

    public Int(String s)
    {   
        int ind_word = 1;
        str_int = s;
        if(s.charAt(0) == '-')
        {
            signo = -1;
            s = s.substring(1, s.length());
            num = new int[s.length()];
            for (int i = 0; i < s.length(); i++ )
            {
                String num_word = s.substring(i, ind_word);
                int value = Integer.parseInt(num_word);
                num[i] = value * signo;
                ind_word += 1;
            }
        }
        else
        {
            num = new int[s.length()];
            for (int i = 0; i < s.length(); i++ )
            {
                String num_word = s.substring(i, ind_word);
                int value = Integer.parseInt(num_word);
                num[i] = value;
                ind_word += 1;
            }
        }
        num = out_zeros(num);
    }   

    public String toString()
    {return "" + str_int;}

    public void plus(Int that)
    {
        int n_postv;
        Int cop_that = new Int(that); //para evitar cambiar el objeto that
        if(num[0] < 0 && cop_that.num[0] < 0)
        {
            for (int i = 0; i < num.length; i++){num[i] = num[i] * -1;}
            for (int i = 0; i < cop_that.num.length; i++){cop_that.num[i] = cop_that.num[i] * -1;}
            num = suma(num, cop_that.num);
            for (int i = 0; i < num.length; i++){num[i] = num[i] * -1;}
        }
        else{num = suma(num, cop_that.num);}
        num = out_zeros(num);
        if(num[0]<0){str_int = "-";signo = -1;}
        else{str_int = "";signo = 1;}
        for (int i = 0; i < num.length; i++ )
        {   
            if(num[i]<0){n_postv = num[i] * -1;}
            else{n_postv = num[i];}
            str_int = str_int + Integer.toString(n_postv);
        }
    }

    public void minus()
    {
        if(signo == -1){ str_int = ""; }
        else { str_int = "-"; }

        int [] str_num = new int[num.length];
        for (int i = 0; i < num.length; i++)
        {
            num[i] = num[i] * -1;

            if(num[i] < 0) { str_num[i] = num[i] * -1; }
            else { str_num[i] = num[i]; }
            
            str_int = str_int + Integer.toString(str_num[i]);
        }
        signo = signo * -1;
    }

    private static int[] llevadas(int[] resul, int size)
    {
        int resul_ampl = 0;
        int ind_resul = resul.length - 1;
        int[] def_resul = new int[size + 1];
        while(ind_resul > -1)
        {
            while(resul[ind_resul] >= 10)
            {
                resul[ind_resul] = resul[ind_resul] - 10;
                if(ind_resul != 0 ){ resul[ind_resul-1] += 1; }
                else
                {
                    def_resul[0] += 1;
                    for (int i = 0; i < resul.length; i++){ def_resul[i+1] = resul[i]; }
                    resul_ampl = 1;
                }
            }
            ind_resul -= 1;
        }
        if(resul_ampl == 1){ return def_resul; }
        else{ return resul; }
    }

    private static int[] suma (int[] oper1, int[] oper2)
    {
        int size = 0;
        int sig_res = 1;
        int dif = 0;

        int[] oper_com1 = new int[oper1.length];
        int[] oper_com2 = new int[oper2.length];        
        if (oper1.length >= oper2.length)
        {
            size = oper1.length;
            dif = oper1.length - oper2.length;
        }
        else
        {
            size = oper2.length;
            dif = oper2.length - oper1.length;
        }
        int[] resul = new int[size];
        int oper_men = 0;
        int comp = 0;
        int llevar = 0;
        int no_neg = 0;

        if(oper1[0] < 0){for(int i = 0; i < oper1.length; i++){oper_com1[i] = oper1[i] * -1;}}else{oper_com1 = oper1;}
        if(oper2[0] < 0){for(int i = 0; i < oper2.length; i++){oper_com2[i] = oper2[i] * -1;}}else{oper_com2 = oper2;}

        if (oper1.length <= oper2.length){ oper_men = oper1.length; }
        
        else{ oper_men = oper2.length; }

        if(oper1.length == oper2.length)
        {
            if(oper_com1[0] > oper_com2[0])
            {
                if(oper_com1[0] < 0){sig_res = -1;} 
            }
            else
            {
                if(oper_com2[0] < 0){sig_res = -1;}
            }
        }
        else if(oper_men == oper1.length && oper2[0] < 0){sig_res = -1;}
        else{ if(oper1[0] < 0){sig_res = -1;} }

        for (int i = 0; i < oper_men; i++){
            if (oper1.length == oper2.length)
            {
                resul[i] = oper1[i] + oper2[i]; 
                if(oper_com2[i] >= oper_com1[i]){llevar += 1;}            
            }
            
            else if(oper1.length > oper2.length){
                for (int n = 0; n < dif; n++){ resul[n] = oper1[n]; }
                resul[i + dif] = oper1[i + dif] + oper2[i];
                if(oper_com2[i] >= oper_com1[i + dif]){llevar += 1;}
            }
            else{
                for (int n = 0; n < dif; n++){ resul[n] = oper2[n]; }
                resul[i + dif] = oper2[i + dif] + oper1[i];
                if(oper_com1[i] >= oper_com2[i + dif]){llevar += 1;}
            }
        }
        int ind_resul = resul.length - 1;

        for (int i = 0; i < resul.length; i++) { if(resul[i] < 0){no_neg = -1;} }
        
        if(no_neg == 0)
        {
            resul = llevadas(resul, size);
            return resul;
        }
        else
        {
            if(llevar != 0){
                //mismo tamaño
                if (oper1.length == oper2.length)
                {
                    if(sig_res == -1)
                    {
                        for(int i = 0; i < resul.length; i++)
                        {
                            if(resul[i] < 0){resul[i] = resul[i] + 1;}
                            else{resul[i] = resul[i] - 10;}
                        }
                    }
                    else
                    {
                        for(int i = ind_resul; i > 0; i--)
                        {
                            if(resul[i] < 0){resul[i] = 10 + resul[i];}
                            else{resul[i] = resul[i] - 1;}
                        }
                    }
                }
                else
                {   //distinto tamaño
                    if(sig_res == -1)
                    {
                        if(oper_men == 1)
                        {
                            if(resul[dif] < 0){
                            resul[dif] = resul[dif] + 10;
                            resul[dif-1] = resul[dif-1] - 1;
                            }
                            else{
                            resul[dif] = resul[dif] - 10;
                            resul[dif-1] = resul[dif-1] + 1;                                
                            }
                        }
                        else
                        {
                            while(ind_resul >= comp)
                            {
                                if(resul[ind_resul] > 0)
                                {
                                    resul[ind_resul] = resul[ind_resul] - 10;
                                    resul[ind_resul-1] = resul[ind_resul-1] + 1;
                                }
                                ind_resul -= 1;
                            }
                        }
                    }
                    else
                    {
                        while(ind_resul >= comp)
                        {
                            if(resul[ind_resul] < 0)
                            {
                                resul[ind_resul] = resul[ind_resul] + 10;
                                resul[ind_resul-1] = resul[ind_resul-1] - 1;
                            }
                            ind_resul -= 1;
                        }
                    }
                }
            }
            return resul;
        }
    }

    public void multiply(Int that)
    {
        int n_postv;
        Int cop_that = new Int(that); //para evitar cambiar el objeto that
        if(num[0] < 0 && cop_that.num[0] < 0)
        {
            for (int i = 0; i < num.length; i++){num[i] = num[i] * -1;}
            for (int i = 0; i < cop_that.num.length; i++){cop_that.num[i] = cop_that.num[i] * -1;}
            num = mult(num, cop_that.num);
            for (int i = 0; i < num.length; i++){num[i] = num[i] * -1;}
        }
        else
        {
            if(num[0] < 0 || cop_that.num[0] < 0)
            {
                if(num[0] < 0)
                { for (int i = 0; i < num.length; i++){num[i] = num[i] * -1;} }
                else
                {for (int i = 0; i < cop_that.num.length; i++){cop_that.num[i] = cop_that.num[i] * -1;} }
                num = mult(num, cop_that.num);
                for (int i = 0; i < num.length; i++){num[i] = num[i] * -1;}
            }
            else{num = mult(num, cop_that.num);}
        }
        if(num[0]<0){str_int = "-";signo = -1;}
        else{str_int = "";signo = 1;}
        for (int i = 0; i < num.length; i++ )
        {   
            if(num[i]<0){n_postv = num[i] * -1;}
            else{n_postv = num[i];}
            str_int = str_int + Integer.toString(n_postv);
        }
    }

    private static int[] mult(int[] oper1, int[] oper2)
    {
        int[] op_mayor, op_men;
        int size_mayor, size_men = 0;
        if (oper1.length <= oper2.length)
        {
            op_mayor = oper2;
            op_men = oper1;
            size_men = oper1.length;
            size_mayor = oper2.length;
        }
        else
        {
            op_mayor = oper1;
            op_men = oper2;
            size_men = oper2.length;
            size_mayor = oper1.length;
        }
        
        int[] resul = new int[size_mayor]; 
        int ctr = 0;
        int man = 0;
        int[] sumando1 = new int[size_mayor];
        int[] suma = new int[size_mayor + size_men];
        int[] ceros = new int[size_mayor];
        for(int i = size_men - 1; i > -1; i--)
        {
            sumando1 = ceros;
            for(int j = 0; j < size_mayor; j++)
            {
                sumando1[j] = op_mayor[j] * op_men[i];
            }
            sumando1 = llevadas(sumando1, size_mayor);
            
            if(ctr == 0)
            {
                man = suma.length - sumando1.length;
                ctr = 1;
                for(int s = 0; s < sumando1.length; s++){suma[s+man] = suma[s+man] + sumando1[s];}
            }
            else
            {
                if(man > 0){man = man - 1;}
                for(int s = 0; s < sumando1.length; s++){suma[s+man] = suma[s+man] + sumando1[s];}
                
            }
            suma = llevadas(suma, suma.length);
        }
        resul = out_zeros(suma);
        return resul;
    }
    
    private static int[] out_zeros (int[] val)
    {
        int size_newlist, nceros = 0;
        int ind = 0;
        while(ind < val.length && val[ind] == 0)
        {
            nceros += 1;
            ind += 1;
        }

        if (nceros == val.length)
        {
            int[] sin_ceros = {0};
            return sin_ceros;
        }
        else
        {
            int size = val.length - nceros; 
            int ind2 = nceros ;
            
            int[] sin_ceros = new int[size];
            ind = 0;

            while(ind < sin_ceros.length)
            {
                sin_ceros[ind] = val[ind2];
                ind += 1;
                ind2 += 1;
            }
            return sin_ceros;
        }
    }

    public int signo(){return signo;}

    public boolean equals(Object that)
    {
        if (this == that) return true;
        if (that == null) return false;
        if (this.getClass() != that.getClass()) { return false; }
        Int obj = (Int) that;
        int igual = 0;
        if ( obj.num.length != this.num.length) { return false; }
        for(int i = 0; i < this.num.length; i++)
        {
            if(this.num[i] == obj.num[i]){igual += 1;}
        }
        if ( igual != this.num.length) { return false; }
        if (this.str_int != obj.str_int) { return false; }
        if (this.signo != obj.signo) { return false; }
        return true;
    }
    //numeros positivos
    public boolean lessThan(Int that)
    {
        String menor = "yes";
        Int cop_this = new Int(this);
        Int cop_that = new Int(that);
        if(this.equals(that)){return false;}
        else
        {
            cop_that.minus();
            cop_this.plus(cop_that);

            if(cop_this.signo() == -1){return true;}
            else{return false;}
        }
    }
}