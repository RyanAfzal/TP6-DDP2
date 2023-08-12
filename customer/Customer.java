package customer;

import java.util.ArrayList;

import order.Cart;
import order.Order;
import product.Product;

public class Customer implements CanShop{
    //TODO: lengkapi kelas berikut
    protected String name;
    protected Cart cart;
    protected ArrayList<Order> ordeHistory;

    public Customer (){

    }
    
    public Customer(String name){
        this.name = name;
    }

    public void addToCart(Product product, int quantity){
        System.out.println();
    }

    public void checkout(){
        System.out.println();
    }

    //getter
    public String getName(){
        return name;
    }
    
}

