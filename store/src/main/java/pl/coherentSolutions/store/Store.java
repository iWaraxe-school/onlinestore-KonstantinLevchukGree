package pl.coherentSolutions.store;

import pl.coherentSolutions.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Category> categoryList;

    public Store() {
        categoryList = new ArrayList<>();
    }

    public void addCategoryToStore(Category category) {
        categoryList.add(category);
    }

    public void printStore() {
        System.out.println("My online store");
        for (Category category : categoryList) {
            category.printCategory();
        }
    }
}
