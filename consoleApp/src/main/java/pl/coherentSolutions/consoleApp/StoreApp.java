package pl.coherentSolutions.consoleApp;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.StoreHelper;
import pl.coherentSolutions.store.utils.XmlParser;
import pl.coherentSolutions.store.utils.comporators.NameComparator;
import pl.coherentSolutions.store.utils.comporators.PriceComparator;
import pl.coherentSolutions.store.utils.comporators.RateComparator;

import java.util.*;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        StoreHelper helper = new StoreHelper(store);
        helper.fillStoreRandomly();
        //   store.printStore();

        XmlParser xmlParser = new XmlParser();
        Map<String, String> sortConfigFromXml = xmlParser.getSortConfigFromXml();
        //    System.out.println(sortConfigFromXml.toString());

        Comparator nameComparator = new NameComparator();
        Comparator priceComparator = new PriceComparator();
        Comparator rateComparator = new RateComparator();

        List<Product> unSortedList = store.getCategoryList().get(0).getProductList();
        unSortedList.forEach(System.out::println);
        Collections.sort(unSortedList, priceComparator);
        System.out.println("-------------------------------------------------");
        unSortedList.forEach(System.out::println);

        int i = 0;
    }
}
