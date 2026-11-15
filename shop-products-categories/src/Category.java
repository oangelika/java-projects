import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;

    private List<Product> products = new ArrayList<Product>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void allProducts(){
        for (Product product : products) {
            System.out.print(getName() + " ");
            System.out.println(product);
        }

    }

    public void removeProduct(int id) {
        products.remove(id);

    }
}
