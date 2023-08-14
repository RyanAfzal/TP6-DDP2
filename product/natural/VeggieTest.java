package product.natural;

import static org.junit.Assert.*;
import org.junit.Test;

public class VeggieTest {
    @Test
    public void checkDiscountTest(){
        Veggie veggie = new Veggie("Jamur",1000, 15, true);
        int expectedOutput = 30;
        int actualOutput = veggie.checkDiscount(6);
        assertEquals(expectedOutput, actualOutput);
    }
}
