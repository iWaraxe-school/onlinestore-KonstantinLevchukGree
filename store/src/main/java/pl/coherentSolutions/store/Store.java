package pl.coherentSolutions.store;

import pl.coherentSolutions.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Category> categoryList;

    public Store() {
        categoryList = new ArrayList<>();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void printStore(){
        System.out.println("My online store");
        for (Category category:categoryList) {
            category.printCategory();
        }
    }
}
