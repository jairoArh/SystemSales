package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceSales {
    private ArrayList<Product> products;
    private ArrayList<Bill> bills;

    public ServiceSales(){
        products = new ArrayList< >( );
        bills = new ArrayList< >( );
    }

    public Product findProduct( String id ){
        for( Product product : products ){
            if( product.getIdProduct().equals( id ) )
                return product;
        }

        return null;
    }

    public boolean addProduct(String idProduct, String description, double value, int stock,ETypeProduct typeProduct, LocalDate dateExpired ){
        if( findProduct( idProduct ) == null ){
            products.add( new Product(idProduct, description, value, stock, typeProduct, dateExpired ) );

            return true;
        }

        return false;
    }

    public Bill findBill( String number ){
        for( Bill bill : bills ){
            if ( bill.getNumber().equals( number ) )
                return bill;
        }
        return null;
    }

    public boolean addBill( String number, LocalDate dateBill ){
        if( findBill( number) == null ){
            bills.add( new Bill( number, dateBill ) );

            return true;
        }

        return false;
    }

    public boolean addDetailSale( String number, String idProduct, short cant ){
        Bill bill = findBill( number );
        if (  bill != null ){
            Product product = findProduct( idProduct );
            if( product != null ){
                return bill.addDetail( product, cant );
            }
        }

        return false;
    }

    public double getValueTotalSales(){
        double sum = 0.0;
        for( Bill bill : bills ){
            sum += bill.calcTotal();
        }

        return sum;
    }

    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) products.clone();
    }

    public ArrayList<Bill> getBills() {
        return (ArrayList<Bill>) bills.clone();
    }
}
