package product;

public abstract class Product {
    // TODO: Implement this class.
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock){
        this.name= name;
        this.price = price;
        this.stock = stock;
    }

    //Getter
    public int getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public String getName(){
        return this.name;
    }
    
    //Setter
    public void decreaseStock(int quantity){
        this.stock -= quantity;
    }

    @Override
    public String toString(){
        return String.format("Produk %s memiliki stok %s", this.name, this.stock);  
    }

    /**
     * Method untuk mendapatkan diskon produk
     * @param quantity jumlah produk yang dibeli
     * @return  diskon
     */
    public abstract int checkDiscount(int quantity);

}
