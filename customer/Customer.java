package customer;

import java.util.ArrayList;
import java.time.LocalDate;

import order.Cart;
import order.Order;
import order.OrderItem;
import product.Product;

public class Customer implements CanShop{
    //TODO: lengkapi kelas berikut
    protected String name;
    protected Cart cart = new Cart();
    protected ArrayList<Order> orderHistory = new ArrayList<>();;

    public Customer (){

    }
    
    public Customer(String name){
        this.name = name;
    }

    @Override
    /**
     * Method untuk memasukkan yang dibeli customer ke cart nya (Override interface)
     * @param product produk yang dibeli
     * @param quantitiy jumlah produk yang dibeli
     */
    public void addToCart(Product product, int quantity){
        this.cart.addOrderItem(new OrderItem(product, quantity));
    }

    @Override
    /**
     * Method untuk checkout customer (Override interface)
     */
    public void checkout(){
        Order order = null;
        order = new Order(this.cart, 0, LocalDate.now());

        this.orderHistory.add(order);
        order.decreaseStockAllItem();
    }

    //getter
    public String getName(){
        return name;
    }

    public Cart getCart(){
        return cart;
    }
    
    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }
}

