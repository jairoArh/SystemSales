package logic;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product aspirina;
    private Product ron;
    private Product frijol;

    private void setup(){
        aspirina = new Product("343","Aspirina",3455,34,ETypeProduct.MEDICINA, LocalDate.of(2020,11,30));
        ron = new Product("944","Ron Boyaca",35000,87,ETypeProduct.LICORES, LocalDate.of(2024,01,05));
        frijol = new Product("prd-343","Frijol x Libra",1800,34,ETypeProduct.VIVERES, LocalDate.of(2020,9,17));
    }

    @Test
    public void testGetStock(){
        setup();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(6 ,3, 4));

    }

    @Test
    public void testIsExpired(){
        setup();
        assertFalse( aspirina.isExpired());
    }

    @Test
    public void testCalcIva(){
        setup();
        assertEquals(552.8, aspirina.calcIva(),0.1);
        assertEquals(6650, ron.calcIva(),0.1);
        assertEquals(144, frijol.calcIva(),0.1);
    }

}