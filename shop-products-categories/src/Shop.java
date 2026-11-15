import java.util.HashMap;
import java.util.Map;

public class Shop {

    private String shopName;

    private Map<String, Category> categories = new HashMap<String, Category>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void addCategory(Category category) {
        categories.put(category.getName(), category);
    }

    public void removeCategory(String categoryName) {
        categories.remove(categoryName);
    }

    public void allCategories() {
        for (Category category : categories.values()) {
            System.out.println(category.getName());
            category.allProducts();
        }
    }



}
