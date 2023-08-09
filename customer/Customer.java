package customer;

import order.Cart;
import product.Product;

public class Customer implements CanShop{
    //TODO: lengkapi kelas berikut
    protected String name;
    protected Cart cart;

    public Customer (){

    }
    
    public Customer(String name){
        this.name = name;
    }

    public void addToCart(Product product, int quantity){
        System.out.println();
    }

    public void checkout(){
        System.out.println();
    }

    //getter
    public String getName(){
        return name;
    }
    
}

