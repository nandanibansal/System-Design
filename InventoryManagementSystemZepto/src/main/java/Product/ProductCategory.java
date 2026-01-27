package Product;

import java.util.*;

public class ProductCategory {
    int categoryId;
    public String categoryName;
    List<Product> products = new ArrayList<>();
    double price;

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int count){
        for(int i=1; i<=count; i++){
            products.remove(0);
        }
    }
}
