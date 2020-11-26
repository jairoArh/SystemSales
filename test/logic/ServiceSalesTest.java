package logic;

import exceptions.ExceptionBillNotExists;
import exceptions.ExpcetionProductNotExists;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ServiceSalesTest {

    private ServiceSales sales;

    private void setupOne(){
        sales = new ServiceSales();
        sales.addProduct( "prd101","Aspirina",2500,45,ETypeProduct.MEDICINA, LocalDate.of(2022, 1,23 ));
        sales.addProduct( "prd201","Old Parr x 750",95000,18,ETypeProduct.LICORES, LocalDate.of(2025, 6,10 ));
        sales.addProduct( "prd301","Jabón Rey",1500,124,ETypeProduct.ASEO, LocalDate.of(2020, 12,7 ));
        sales.addProduct( "prd401","Arroz",1800,230,ETypeProduct.VIVERES, LocalDate.of(2019, 11,23 ));
    }

    private void setupTwo(){
        setupOne();
        sales.addBill("7632",LocalDate.of( 2019,10,21));
        sales.addBill("6546",LocalDate.of( 2020,05,10));
        sales.addBill("3244",LocalDate.of( 2020,10,21));
    }

    @Test
    public void testAddDetailSale() throws ExceptionBillNotExists, ExpcetionProductNotExists {
        setupTwo();
        assertTrue( sales.addDetailSale( "7632","prd101",(short)5 ) );
        assertFalse( sales.addDetailSale( "7632","prd1601",(short)5 ) );
        assertFalse( sales.addDetailSale( "7632","prd201",(short)14 ) );
        assertFalse( sales.addDetailSale( "754632","prd201",(short)14 ) );
        assertEquals( 40, sales.findProduct("prd101").getStock());
        assertTrue( sales.addDetailSale( "7632","prd201",(short)5 ) );
    }

    @Test
    public void testGetTotal() throws ExceptionBillNotExists, ExpcetionProductNotExists {
        setupTwo();
        assertTrue( sales.addDetailSale( "7632","prd101",(short)5 ) );
        assertTrue( sales.addDetailSale( "7632","prd201",(short)5 ) );
        assertEquals(487500, sales.getValueTotalSales(),0.1);
    }

    @Test
    public void testFindProduct(){
        setupOne();
        assertNull( sales.findProduct("w64gr"));
        assertNotNull( sales.findProduct("prd101"));
        assertEquals( "Aspirina",sales.findProduct("prd101").getDescription());
    }

    @Test
    public void testAddBill(){
        setupOne();
        assertTrue( sales.addBill("4353",LocalDate.of(2020,10,21)));
        assertFalse( sales.addBill("4353",LocalDate.of(2019,8,21)));
        assertTrue( sales.addBill("5367",LocalDate.of(2020,10,21)));
        assertEquals(2, sales.getBills().size());
    }

    @Test
    public void testFindBill(){
        setupTwo();
        assertNull( sales.findBill("4534535"));
        assertNotNull( sales.findBill("6546"));
        assertEquals("6546",sales.findBill("6546").getNumber());
    }

}