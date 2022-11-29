package pl.coherentSolutions.domain;

import pl.coherentSolutions.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private List<Product> productList;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addProduct(Product product) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.add(product);
    }
}
