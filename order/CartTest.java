package order;

import static org.junit.Assert.*;
import org.junit.Test;

import customer.Customer;
import product.Product;
import product.natural.Fruit;
import product.natural.Veggie;

public class CartTest {
    
    @Test
    public void getTotalPriceTest(){
        Customer customer = new Customer("Hana");
        
        Product apel = new Fruit("Apel",13000, 50, true);
        Product bayam = new Veggie("Bayam",1000, 20, false);
        
        customer.addToCart(bayam, 15);
        customer.addToCart(apel, 10);
        
        int expectedOutput = 103000;
        int actualOutput = customer.getCart().getTotalPrice();
        assertEquals(expectedOutput, actualOutput);
    }
}
