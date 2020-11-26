package logic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {
    private Bill bill;
    private Product aspirina;
    private Product ron;
    private Product frijol;

    private void setupOne(){
        aspirina = new Product("343","Aspirina",3455,34,ETypeProduct.MEDICINA, LocalDate.of(2020,11,30));
        ron = new Product("944","Ron Boyaca",35000,87,ETypeProduct.LICORES, LocalDate.of(2024,01,05));
        frijol = new Product("prd-343","Frijol x Libra",1800,10,ETypeProduct.VIVERES, LocalDate.of(2020,9,17));
        bill = new Bill( "345345", LocalDate.now());
    }

    private void setupTwo(){
        setupOne();
        bill.addDetail( frijol, ( short ) 5 );
        bill.addDetail( ron, ( short )80 );
        bill.addDetail(aspirina,( short )12);
    }

    @Test
    public void testAddDetail(){
        setupOne();
        assertTrue( bill.addDetail( frijol, ( short ) 5 ) );
        assertEquals(5, frijol.getStock( ) );
        assertFalse( bill.addDetail( frijol, ( short ) 1 ) );

        assertFalse( bill.addDetail( ron, ( short )85 ) );
        assertTrue( bill.addDetail( ron, ( short )80 ) );
        assertEquals(7, ron.getStock( ) );
    }

    @Test
    public void testCalcTotal(){
        setupTwo();
        assertEquals( 2850460, bill.calcTotal(),0.1);
    }

}