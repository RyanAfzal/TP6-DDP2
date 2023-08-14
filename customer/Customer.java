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

    public void addToCart(Product product, int quantity){
        this.cart.addOrderItem(new OrderItem(product, quantity));
    }

    public void checkout(){
        if (this.cart.getOrderItemList().isEmpty()){
            System.out.println("Keranjang Anda kosong");
        }

        else{
            for(OrderItem item : this.cart.getOrderItemList()){
                
            }
        }
    }

    //getter
    public String getName(){
        return name;
    }
    
}

