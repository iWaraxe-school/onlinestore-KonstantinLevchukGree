package pl.coherentSolutions.store.utils;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.comporators.NameComparator;
import pl.coherentSolutions.store.utils.comporators.PriceComparator;
import pl.coherentSolutions.store.utils.comporators.RateComparator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.coherentSolutions.store.constant.XmlKey.asc;
import static pl.coherentSolutions.store.constant.XmlKey.desc;

public class SortHelper {
    Store store;

    public List<Product> getProductList() {
        return store.getAllProducts();
    }

    public SortHelper(Store store) {
        this.store = store;
    }

    public List<Product> sortedProductList(Map<String, String> sortConfigFromXml, String value) {
        List<Product> allProduct = store.getAllProducts();
        for (Map.Entry<String, String> entry : sortConfigFromXml.entrySet()) {
            switch (value) {
                case "name":
                    if (entry.getValue().equals(asc)) {
                        allProduct.sort(new NameComparator());
                    } else if (entry.getValue().equals(desc)) {
                        allProduct.sort(new NameComparator().reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                case "price":
                    if (entry.getValue().equals(asc)) {
                        allProduct.sort(new PriceComparator());
                    } else if (entry.getValue().equals(desc)) {
                        allProduct.sort(new PriceComparator().reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                case "rate":
                    if (entry.getValue().equals(asc)) {
                        allProduct.sort(new RateComparator());
                    } else if (entry.getValue().equals(desc)) {
                        allProduct.sort(new RateComparator().reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected sorting value");
            }
        }
        return allProduct;
    }

    public List<Product> sortByXml(String value) {
        XmlParser parser = new XmlParser();
        Map<String, String> configMap = parser.getSortConfigFromXml();
        return sortedProductList(configMap, value);
    }

    public List<Product> topExpensiveProduct(int amount) {
        List<Product> allProduct = store.getAllProducts();
        allProduct.sort(new PriceComparator().reversed());
        return allProduct.stream().limit(amount).collect(Collectors.toList());
    }

    public void printListProduct(List<Product> productList) {
        productList.forEach(System.out::println);
    }
}
