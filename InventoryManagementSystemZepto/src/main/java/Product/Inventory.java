package Product;

import java.util.*;

public class Inventory {
    public List<ProductCategory> productCategoryList;

    public Inventory(){
        productCategoryList = new ArrayList<>();
    }

    public void addCategory(int categoryId, String name, int price){
        ProductCategory category = new ProductCategory();
        category.price = price;
        category.categoryName = name;
        category.categoryId = categoryId;
        productCategoryList.add(category);
    }

    public void addProduct(Product product, int productCategoryId){
        System.out.println("Added product: "+ product.productName);
        ProductCategory category = null;
        for(ProductCategory productCategory: productCategoryList){
            if(productCategory.categoryId == productCategoryId){
                category = productCategory;
            }
        }

        if(category!=null){
            category.addProduct(product);
        }
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){
        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()){
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            category.removeProduct(entry.getValue());
        }
    }

    public ProductCategory getProductCategoryFromID(int productCategoryId){
        for(ProductCategory productCategory: productCategoryList){
            if(productCategory.categoryId == productCategoryId){
                return productCategory;
            }
        }
        return null;
    }
}
