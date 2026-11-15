public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart("John Smith");

        Product product1 = new Product("Mleko", 2.5);
        product1.addToShoppingCart(cart);
        cart.addProduct(product1);

        Product product2 = new Product("Chleb", 3.0);
        product2.addToShoppingCart(cart);
        cart.addProduct(product2);

        cart.displayProducts();
    }
}