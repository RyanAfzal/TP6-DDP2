import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import customer.GoldCustomer;
import order.Order;
import order.OrderItem;
import product.Product;
import product.natural.Fruit;
import product.natural.Veggie;
import product.processed.Diary;

public class ShyourBox {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private Customer loginCustomer;

    public static void main(String[] args) {
        ShyourBox app = new ShyourBox();
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        app.initProducts();
        app.initCustomers();

        Scanner scanner = new Scanner(System.in);
        int choice;

        //Untuk awal login
        do {
            System.out.println("Menu" +
                    "\n1. Login" +
                    "\n0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Masukkan nama pengguna:");
                    String user = scanner.next();
                    //TODO: implement Login
                    app.loginCustomer = app.searchCustomer(user);
                    if(app.loginCustomer == null){
                        System.out.println("Customer tidak ditemukan");
                        System.out.println();
                        break;
                    }
                    app.customerMenu();
                    break;
                case 0:
                    System.out.println("Sampai Jumpa!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }

        } while (choice != 0);
        scanner.close();
        
    }


    //Menu yang dapat dipilih customer
    public void customerMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------Customer "+this.loginCustomer.getName()+ " Menu------------------" +
                    "\n1. Lihat Keranjang" +
                    "\n2. Tambah Produk ke Keranjang" +
                    "\n3. Checkout Keranjang" +
                    "\n4. Riwayat Pemebelian" +
                    "\n0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    //TODO : implement lihat keranjang
                    // use PrintGenericList for this feature
                    this.lihatKeranjang();
                    break;
                case 2:
                    //TODO : Implement add to cart
                    this.tambahProduk(scanner);
                    break;

                case 3:
                    //TODO: Implement Checkout
                    this.checkout();
                    break;
                case 4:
                   //TODO: Implement Order History
                   // use PrintGenericList for this feature
                    this.lihatRiwayatPembelian();
                    break;
                case 0:
                    this.loginCustomer = null;
                    System.err.println("Sampai Jumpa Kembali!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice !=0);
       
    }

    public void initProducts(){
        this.products.add(new Veggie("Bayam",1000, 20, false));
        this.products.add(new Veggie("Jamur",1000, 15, true));
        this.products.add(new Veggie("Wortel",1000, 15, true));

        this.products.add(new Fruit("Jeruk",10000, 20, false));
        this.products.add(new Fruit("Apel",13000, 50, true));
        this.products.add(new Fruit("Semangka",9000, 23, false));
        
        this.products.add(new Diary("Keju", 30000, 20, "06 08 2023"));
        this.products.add(new Diary("Yogurt", 15000, 10, "06 08 2026"));
    }

    public void initCustomers(){
        this.customers.add(new Customer("Hana"));
        this.customers.add(new Customer("Sakura"));
        this.customers.add(new Customer("Jennifer"));
        this.customers.add(new GoldCustomer("Anyujin"));
        this.customers.add(new GoldCustomer("Chaewon"));
    }


    /**
     * Method untuk mencari produk berdasarkan nama.
     * 
     * @param name nama produk
     * @return produk yang dicari
     */
    public Product searchProduct(String name) {
        // TODO: Implement this method.
        for(Product product : products){
            if (product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }

        return null;
    }

    /**
     * Method untuk mencari customer berdasarkan nama
     * @param name nama customer
     * @return customer yang dicari
     */
    public Customer searchCustomer(String name) {
        // TODO: Implement this method.
        for(Customer customer : customers){
            if (customer.getName().equalsIgnoreCase(name)){
                return customer;
            }
        }

        return null;
    }
    
    /**
     * Method untuk handle menu customer 1
     */
    public void lihatKeranjang() {
        if (this.loginCustomer.getCart().getOrderItemList().isEmpty()) {
            System.out.println("\nKeranjang Anda Kosong");
            return;
        }
        
        else{
            System.out.println("Isi keranjang: ");
            new PrintGenericList<>(this.loginCustomer.getCart().getOrderItemList()).printToConsole();
        }
    }

    /**
     * Method untuk handle menu customer 2
     * @param scanner scanner untuk menerima input
     */
    public void tambahProduk(Scanner scanner){
        for(Product product : products){
            System.out.println("- Produk " + product.getName() + " memiliki stok " + product.getStock());
        }
        System.out.println();

        System.out.print("Nama produk yang ingin dibeli: ");
        String produkDibeli = scanner.next();
        System.out.print("Masukan jumlah produk yang ingin dibeli : ");
        int jmlProduk = scanner.nextInt();

        if(searchProduct(produkDibeli) != null){
            if(searchProduct(produkDibeli).getStock() >= jmlProduk){
                this.loginCustomer.addToCart(searchProduct(produkDibeli), jmlProduk);
                System.out.println("Berhasil menambahkan " + produkDibeli + " ke keranjang");
            }
            else{
                System.out.println("Stok produk tidak mencukupi");
            } 
        }

        else{
            System.out.println("Produk tidak ditemukan");
        }
    }

    /**
     * Method untuk handle menu customer 3
     */
    public void checkout(){
        ArrayList<OrderItem> checkoutItemList = new ArrayList<>(); 
        if (this.loginCustomer.getCart().getOrderItemList().isEmpty()) {
            System.out.println("Keranjang Anda kosong");
        }

        else{
            for (OrderItem orderItem : this.loginCustomer.getCart().getOrderItemList()) {
                int quantity = orderItem.getQuantity();
                for (Product product : products) {
                    if (product.getName().equals(orderItem.getProduct().getName())) {
                        if (product.getStock() < quantity) {
                            System.out.println("Gagal checkout");
                            return;
                        }
    
                        else{
                            checkoutItemList.add(orderItem);
                            product.decreaseStock(quantity);
                        }
                    }
                }
            }
            
            this.loginCustomer.checkout();
    
            System.out.println("Berhasil Checkout");
        }
    }

    /**
     * Method untuk handle menu customer 4
     */
    public void lihatRiwayatPembelian(){
        new PrintGenericList<>(this.loginCustomer.getOrderHistory()).printToConsole();
    }

}

