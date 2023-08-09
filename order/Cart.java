package order;

import java.util.ArrayList;

public class Cart {
    //TODO: Lengkapi kelas berikut
    private ArrayList<OrderItem> orderList = new ArrayList<>();

    public Cart(){

    }

    /**
     * Untuk mendapatkan total harga produk yang dibeli
     * @return total harga produk
     */
    public int getTotalPrice() {
        // TODO: Implement this method.
        int totalPrice = 0;

        for (OrderItem item : orderList){
            totalPrice += item.getFinalPrice();
        }

        return totalPrice;
    }

    /**
     * Untuk menambahkan produk ke daftar produk yang dibeli
     * @param orderItem produk yang dibeli
     */
    public void addOrderItem(OrderItem orderItem) {
        // TODO: Implement this method.
        this.orderList.add(orderItem);
    }

    //getter
    public ArrayList<OrderItem> getOrderItemList(){
        return orderList;
    }
}

