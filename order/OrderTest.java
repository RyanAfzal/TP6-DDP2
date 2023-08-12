package order;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrderTest {
    
    @Test
    public void getFinalPriceTest(){
        Order order = new Order();
        double expectedOutput = 0.0;
        double actualOutput = order.getFinalPrice();
        assertEquals(expectedOutput, actualOutput, 0.000001);
    }
}
