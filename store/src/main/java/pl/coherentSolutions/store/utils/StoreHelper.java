package pl.coherentSolutions.store.utils;

import org.reflections.scanners.SubTypesScanner;
import pl.coherentSolutions.domain.Category;
import pl.coherentSolutions.domain.categories.Bike;
import pl.coherentSolutions.domain.categories.Milk;
import pl.coherentSolutions.domain.categories.Phone;
import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class StoreHelper {
    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

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
        Map<Category, Integer> productToAdd = new HashMap<>();

        Reflections reflections = new Reflections("pl.coherentSolutions.domain.categories");
        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type : subTypes) {

            try {
                Random random = new Random();
                productToAdd.put(type.getConstructor().newInstance(), random.nextInt(10));

            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return productToAdd;
    }
}
