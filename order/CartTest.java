package order;

import static org.junit.Assert.*;
import org.junit.Test;

public class CartTest {
    
    @Test
    public void getTotalPriceTest(){
        Cart cart = new Cart();
        int expectedOutput = 0;
        int actualOutput = cart.getTotalPrice();
        assertEquals(expectedOutput, actualOutput);
    }
}
