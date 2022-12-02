package pl.coherentSolutions.domain;

import pl.coherentSolutions.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String name;
    private List<Product> productList;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.add(product);
    }

    public List<Product> getProductList (){
        return productList;
    }
    public void printCategory() {
        System.out.println(name + ":");
        for (Product product : productList) {
            product.printProduct();
        }
    }
}
