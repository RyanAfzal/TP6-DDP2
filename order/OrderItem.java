package order;
import product.Product;

public class OrderItem {
    private Product product;

    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity  = quantity;

    };

    /**
     * Untuk mendapatkan harga akhir item yang dibeli
     * @return harga akhir item yang dibeli
     */
    public double getFinalPrice() {
        double discount = this.product.checkDiscount(this.quantity);
        double price = (double) this.product.getPrice() * this.quantity;

        return (price*(100-discount)/100);
    }

    //Getter
    public Product getProduct() {
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    //Setter
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return String.format("%s  %d kg  %f", this.product.getName(), this.quantity, this.getFinalPrice());  
    }
}
