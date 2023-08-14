package customer;

import java.time.LocalDate;

import order.Cart;
import order.Order;

public class GoldCustomer extends Customer {
    //TODO: lengkapi kelas berikut
    private String name;

    public GoldCustomer(String name){
        super(name);
    }  

    @Override
    /**
     * Method untuk checkout Goldcustomer (Override interface)
     */
    public void checkout(){
        Order order = null;
        order = new Order(this.cart, 0.85, LocalDate.now());

        this.orderHistory.add(order);
        order.decreaseStockAllItem();
    }
}
