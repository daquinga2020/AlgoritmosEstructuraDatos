package ayedd.e3;
import edu.princeton.cs.algs4.*;
public class ClientInt{

    public static void main(String[] args){
        try
        {
            Int num1 = new Int(args[0]);
            Int num2 = new Int(args[2]);
            String operador = args[1];
            if(operador.equals("-") || operador.equals("+"))
            {
                if(operador.equals("-"))
                {
                    num2.minus();
                    num1.plus(num2);
                }
                else
                {
                    num1.plus(num2);
                }
                StdOut.println(num1.toString());
            }
            else
            {
                StdOut.println("Introduzca un operador válido.");
                System.exit(1);
            }
        }
        catch(NumberFormatException e1){
            System.err.println("Valor introducido incorrecto." );
            System.exit(1);
        }
        catch(ArrayIndexOutOfBoundsException e2){
            System.err.println("Introduzca de nuevo 3 argumentos." );
            System.exit(1);
        }
    }
}