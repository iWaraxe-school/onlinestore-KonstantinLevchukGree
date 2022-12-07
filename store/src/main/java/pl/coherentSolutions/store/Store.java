package pl.coherentSolutions.store;

import pl.coherentSolutions.domain.Category;
import pl.coherentSolutions.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private final List<Category> categoryList;

    public Store() {
        categoryList = new ArrayList<>();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void addCategoryToStore(Category category) {
        categoryList.add(category);
    }

    public List<Product> getAllProducts() {
        return categoryList.stream()
                .flatMap(category -> category.getProductList().stream())
                .collect(Collectors.toList());
    }

    public void printStore() {
        System.out.println("My online store");
        for (Category category : categoryList) {
            category.printCategory();
        }
    }
}
