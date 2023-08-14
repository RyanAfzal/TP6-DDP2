package customer;

import java.util.ArrayList;

import order.Cart;
import order.Order;
import order.OrderItem;
import product.Product;

public class Customer implements CanShop{
    //TODO: lengkapi kelas berikut
    protected String name;
    protected Cart cart;
    protected ArrayList<Order> orderHistory;

    public Customer (){

    }
    
    public Customer(String name){
        this.name = name;
        this.cart = new Cart();
        this.orderHistory = new ArrayList<>();
    }

    @Override
    public void addToCart(Product product, int quantity){
        this.cart.addOrderItem(new OrderItem(product, quantity));
    }

    @Override
    public void checkout(){
        
    }

    //getter
    public String getName(){
        return name;
    }

    public Cart getCart(){
        return cart;
    }
    
}

