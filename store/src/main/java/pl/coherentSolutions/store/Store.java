package pl.coherentSolutions.store;

import pl.coherentSolutions.domain.Category;
import pl.coherentSolutions.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private static volatile Store instance;
    private final List<Category> categoryList;

    private Store() {
        categoryList = new ArrayList<>();
    }

    //Singleton
    public static Store getInstance() {
        Store result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Store.class) {
            if (instance == null) {
                instance = new Store();
            }
            return instance;
        }
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
