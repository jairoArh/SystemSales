package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
    private String number;
    private LocalDate dateBill;
    private ArrayList<Detail> details;

    public Bill(String number, LocalDate dateBill) {
        details = new ArrayList<>();
        this.number = number;
        this.dateBill = dateBill;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDateBill() {
        return dateBill;
    }

    public void setDateBill(LocalDate dateBill) {
        this.dateBill = dateBill;
    }

    public double calcTotal(){
        double sum = 0.0;
        for( Detail detail : details ){
            sum += detail.calcSubtotal( );
        }

        return sum;
    }

    public boolean addDetail( Product product, short cant ){
        if ( cant <= ( product.getStock() - Product.STOCK_MIN ) ){
            details.add( new Detail( product, cant ) );
            product.setStock( product.getStock() - cant );

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "number='" + number + '\'' +
                ", dateBill=" + dateBill +
                '}';
    }

    private class Detail{
        private Product product;
        private short cant;

        public Detail(Product product, short cant) {
            this.product = product;
            this.cant = cant;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public short getCant() {
            return cant;
        }

        public void setCant(short cant) {
            this.cant = cant;
        }

        public double calcSubtotal(){
            return product.getValue() * cant;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "product=" + product +
                    ", cant=" + cant +
                    '}';
        }
    }
}
