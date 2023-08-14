package order;

import static org.junit.Assert.*;
import org.junit.Test;

import product.natural.Fruit;

public class OrderItemTest {
    
    @Test
    public void getFinalPriceTest(){
        OrderItem orderItem = new OrderItem(new Fruit("Apel",13000, 50, true), 10);
        double expectedOutput = 91000.0;
        double actualOutput = orderItem.getFinalPrice();
        assertEquals(expectedOutput, actualOutput, 0.00001);
    }
}
