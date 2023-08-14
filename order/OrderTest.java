package order;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import customer.Customer;
import customer.GoldCustomer;
import product.Product;
import product.natural.Fruit;
import product.natural.Veggie;

public class OrderTest {
    
    @Test
    public void getFinalPriceTest(){
        Customer anyujin = new GoldCustomer("Anyujin");
        Product apel = new Fruit("Apel",13000, 50, true);
        Product bayam = new Veggie("Bayam",1000, 20, false);
        anyujin.addToCart(bayam, 15);
        anyujin.addToCart(apel, 10);
        Order order = new Order(anyujin.getCart(),0.85,LocalDate.now());
        double expectedOutput = 15450.0;
        double actualOutput = order.getFinalPrice();
        assertEquals(expectedOutput, actualOutput, 0.00001);
    }
}
