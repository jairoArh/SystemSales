package test;

import logic.ETypeProduct;
import logic.Product;
import sun.misc.Cleaner;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Runner {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

        try{
            String name = input.readLine();

            int numOne = Integer.parseInt(JOptionPane.showInputDialog("Digite Dividendo"));
            int numTwo = Integer.parseInt(JOptionPane.showInputDialog("Digite Divisor"));
            System.out.printf("La Division de %d entre %d = %d\n",numOne,numTwo, numOne / numTwo);
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }catch (ArithmeticException ex){
            JOptionPane.showMessageDialog( null,"No se Puede Dividir entre cero","Error",JOptionPane.ERROR_MESSAGE);
        }
        System.out.printf("FIN OK");
    }
}
