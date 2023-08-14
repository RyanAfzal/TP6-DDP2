package customer;
import product.Product;

public interface CanShop {

    /**
     * Method untuk memasukkan yang dibeli customer ke cart nya
     * @param product produk yang dibeli
     * @param quantity jumlah produk yang dibeli
     */
    void addToCart(Product product, int quantity);

    /**
     * Method untuk checkout
     */
    void checkout();
}
