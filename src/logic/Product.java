package logic;

import java.time.LocalDate;

public class Product {
    private String idProduct;
    private String description;
    private double value;
    private int stock;
    public static final byte STOCK_MIN = 5;
    private ETypeProduct typeProduct;
    private LocalDate dateExpired;

    public Product(String idProduct, String description, double value, int stock, ETypeProduct typeProduct, LocalDate dateExpired) {
        this.idProduct = idProduct;
        this.description = description;
        this.value = value;
        this.stock = stock;
        this.typeProduct = typeProduct;
        this.dateExpired = dateExpired;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ETypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(ETypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public LocalDate getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(LocalDate dateExpired) {
        this.dateExpired = dateExpired;
    }

    public boolean isExpired(){
        //TODO Implementar método
        LocalDate newDate = LocalDate.now();

        return false;
    }

    public double calcIva(){
        //MEDICINAS --> 16%, LICORES --> 19%, ASEO --> 12%, VIVERES --> 8%

        switch (typeProduct){
            case VIVERES: return value * 0.08;

            case ASEO: return value * 0.12;

            case MEDICINA: return value * 0.16;

            default: return value * 0.19;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", stock=" + stock +
                ", typeProduct=" + typeProduct +
                ", dateExpired=" + dateExpired +
                '}';
    }
}
