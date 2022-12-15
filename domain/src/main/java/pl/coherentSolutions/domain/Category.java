package pl.coherentSolutions.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.coherentSolutions.products.Product;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Getter
public abstract class Category {
    private final String name;
    private List<Product> productList;

    public void addProduct(Product product) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.add(product);
    }

    public void printCategory() {
        System.out.println(name + ":");
        for (Product product : productList) {
            product.printProduct();
        }
    }
}
