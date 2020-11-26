package test;

import exceptions.ExceptionBillNotExists;
import exceptions.ExpcetionProductNotExists;
import logic.ETypeProduct;
import logic.ServiceSales;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class Runner {
    ServiceSales sales;

    public Runner(){
        sales = new ServiceSales();
    }
    public static void main(String[] args) throws IOException {

        Runner run = new Runner();
        run.addProducts();
        run.addBills();
        run.tests();
    }

    private  void tests() {
        try {
            if( sales.addDetailSale( "7632","prd101",(short)40)){
                JOptionPane.showMessageDialog(null, "Hecho, Se adiciona el Producto","OK",JOptionPane.OK_OPTION);
            }else{
                JOptionPane.showMessageDialog(null, "No Hay Suficientes Existencias","Error",JOptionPane.ERROR_MESSAGE);
            }

            if( sales.addDetailSale( "7632","prd101",(short)1)){
                JOptionPane.showMessageDialog(null, "Hecho, Se adiciona el Producto","OK",JOptionPane.OK_OPTION);
            }else{
                JOptionPane.showMessageDialog(null, "No Hay Suficientes Existencias","Error",JOptionPane.ERROR_MESSAGE);
            }

            //sales.addDetailSale("4364","prd646",(short)10);
            sales.addDetailSale("6546","prd646",(short)10);
        } catch (ExceptionBillNotExists exceptionBillNotExists) {
            JOptionPane.showMessageDialog(null, exceptionBillNotExists.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (ExpcetionProductNotExists expcetionProductNotExists) {
            JOptionPane.showMessageDialog(null, expcetionProductNotExists.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

        System.out.println("FIN OK");
    }

    private void addBills() {
        sales.addBill("7632",LocalDate.of( 2019,10,21));
        sales.addBill("6546",LocalDate.of( 2020,05,10));
        sales.addBill("3244",LocalDate.of( 2020,10,21));
    }

    private void addProducts() {
        sales.addProduct( "prd101","Aspirina",2500,45,ETypeProduct.MEDICINA, LocalDate.of(2022, 1,23 ));
        sales.addProduct( "prd201","Old Parr x 750",95000,18,ETypeProduct.LICORES, LocalDate.of(2025, 6,10 ));
        sales.addProduct( "prd301","Jabón Rey",1500,124,ETypeProduct.ASEO, LocalDate.of(2020, 12,7 ));
        sales.addProduct( "prd401","Arroz",1800,230,ETypeProduct.VIVERES, LocalDate.of(2019, 11,23 ));
    }
}
