package order;

import java.time.LocalDate;

import product.Product;

public class Order {
    //TODO: Lengkapi kelas berikut
    private Cart cart;
    private double discountRate;
    private LocalDate orderdate;
    private double totalPrice;

    public Order(Cart cart, double discountRate, LocalDate orderDate){
        this.cart = cart;
        this.discountRate = discountRate;
        this.orderdate = orderDate;
        this.totalPrice = this.cart.getTotalPrice() * (1 - this.discountRate);
    }

    /**
     * Method untuk mendapatkan harga akhir order
     * @return harga akhir order
     */
    public double getFinalPrice(){
        double finalPrice = this.totalPrice;
        return finalPrice;
    }

    /**
     * Untuk mengurangi semua stock item yang dicheckout
     */
    public void decreaseStockAllItem(){
        for (OrderItem item : this.cart.getOrderItemList()){
            Product product = item.getProduct();
            int jmlDibeli = item.getQuantity();
            product.decreaseStock(jmlDibeli);
        }
    }

    @Override
    public String toString() {
        String output = "";
        output += "Tanggal Checkout        : " + this.orderdate.toString();
        output += "\nTotal Harga     : " + String.format("%f", this.getFinalPrice());
        output += "\nDaftar Pembelian        :\n";
        for (OrderItem item : cart.getOrderItemList()) {
            output += item.toString() + "\n";
        }
        return output;
    }
}
