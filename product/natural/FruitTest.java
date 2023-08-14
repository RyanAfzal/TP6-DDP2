package product.natural;

import static org.junit.Assert.*;
import org.junit.Test;

public class FruitTest {
    
    @Test
    public void checkDiscountTest(){
        Fruit fruit = new Fruit("Apel",13000, 50, true);
        int expectedOutput = 30;
        int actualOutput = fruit.checkDiscount(10);
        assertEquals(expectedOutput, actualOutput);
    }
}
