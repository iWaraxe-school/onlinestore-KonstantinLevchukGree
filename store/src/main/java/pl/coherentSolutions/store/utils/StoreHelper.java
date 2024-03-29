package pl.coherentSolutions.store.utils;

import lombok.RequiredArgsConstructor;
import org.reflections.Reflections;
import pl.coherentSolutions.domain.Category;
import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
@RequiredArgsConstructor
public class StoreHelper {
    private final Store store;



    public void fillStoreRandomly() {

        Set<Category> categorySet = createProductListToAdd();

        for (Category category : categorySet) {
            Random random = new Random();
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                Product product = FactoryProduct.getProduct(category.getName());
                category.addProduct(product);
            }
            this.store.addCategoryToStore(category);
        }
    }

    public static Set<Category> createProductListToAdd() {
        Set<Category> categoryToAdd = new HashSet<>();

        Reflections reflections = new Reflections("pl.coherentSolutions.domain.categories");
        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);
        for (Class<? extends Category> type : subTypes) {
            try {
                Category category = type.getConstructor().newInstance();
                categoryToAdd.add(category);
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                     InstantiationException e) {
                e.printStackTrace();
            }
        }
        return categoryToAdd;
    }
}
