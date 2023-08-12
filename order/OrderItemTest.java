package order;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrderItemTest {
    
    @Test
    public void getFinalPriceTest(){
        OrderItem orderItem = new OrderItem(null, 0);
        double expectedOutput = 0.0;
        double actualOutput = orderItem.getFinalPrice();
        assertEquals(expectedOutput, actualOutput, 0.0001);
    }
}
