package order;

import java.time.LocalDate;

public class Order {
    //TODO: Lengkapi kelas berikut
    private Cart cart;
    private double discountRate;
    private LocalDate orderdate;
    private double totalPrice;

    public Order(){

    }

    public double getFinalPrice(){
        return 0.0;
    }
}
