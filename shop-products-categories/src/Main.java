public class Main {
    public static void main(String[] args) {

        Product milk = new Product("milk",2.0,3,6);
        Product meat = new Product("meat",10.0,5,12);
        Product fruit = new Product("fruit",5.0,4,8);


        Category food = new Category();
        Category food2 = new Category();
        Category food3 = new Category();


        Shop shop = new Shop();

        shop.setShopName("piaterochka");

        food.setName("food");
        food2.setName("food2");
        food3.setName("food3");

        food.addProduct(milk);
        food.addProduct(meat);
        food.addProduct(fruit);

        food2.addProduct(meat);
        food2.addProduct(fruit);
        food3.addProduct(milk);


        food.allProducts();
        food2.allProducts();
        food3.allProducts();

        shop.addCategory(food3);
        shop.addCategory(food);
        shop.addCategory(food2);


        System.out.println();

        shop.allCategories();

        }
    }
