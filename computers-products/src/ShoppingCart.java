class ShoppingCart {
    private String customerName;
    private Product[] products;
    private int productCount;

    public ShoppingCart(String customerName) {
        this.customerName = customerName;
        this.products = new Product[10];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Koszyk jest już pełny!");
        }
    }

    public void displayProducts() {
        System.out.println("Produkty w koszyku:");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + " - " + products[i].getPrice());
        }
    }
}


