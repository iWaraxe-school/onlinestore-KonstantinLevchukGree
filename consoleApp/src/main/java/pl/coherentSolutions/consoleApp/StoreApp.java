package pl.coherentSolutions.consoleApp;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.constant.SortKey;
import pl.coherentSolutions.store.utils.SortHelper;
import pl.coherentSolutions.store.utils.StoreHelper;

import java.util.List;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        StoreHelper helper = new StoreHelper(store);
        helper.fillStoreRandomly();

        List<Product> unSortedList = store.getAllProducts();
        unSortedList.forEach(System.out::println);

        SortHelper sortHelper = new SortHelper(store);
        List<Product> sorted = sortHelper.sortByXml(SortKey.NAME.getKey());
        sorted.forEach(System.out::println);
    }
}
