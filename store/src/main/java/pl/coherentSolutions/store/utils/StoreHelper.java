package pl.coherentSolutions.store.utils;

import pl.coherentSolutions.domain.Category;
import pl.coherentSolutions.domain.categories.Bike;
import pl.coherentSolutions.domain.categories.Milk;
import pl.coherentSolutions.domain.categories.Phone;
import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;

import java.util.HashMap;
import java.util.Map;

public class StoreHelper {
    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

    //video 03.oop.solutions.reflections.01(HDReady)
    public void fillStoreRandomly() {

        RandomStorePopulator populator = new RandomStorePopulator();
        Map<Category, Integer> categoryProductsMapToAdd = createProductListToAdd();

        for (Map.Entry<Category, Integer> entry : categoryProductsMapToAdd.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {

                Product product = new Product(
                        populator.getProductName(entry.getKey().getName()),
                        populator.getProductPrice(),
                        populator.getProductRate());
                entry.getKey().addProduct(product);
            }
            this.store.getCategoryList().add(entry.getKey());
        }
    }

    // reflections
    private static Map<Category, Integer> createProductListToAdd() {
        Map<Category, Integer> newCategoryMap = new HashMap<>();
        newCategoryMap.put(new Bike(), 15);
        newCategoryMap.put(new Milk(), 15);
        newCategoryMap.put(new Phone(), 15);
        return newCategoryMap;
    }
}
