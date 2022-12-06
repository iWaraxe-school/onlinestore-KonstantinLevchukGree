package pl.coherentSolutions.store.utils;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.coherentSolutions.store.constant.XmlKey.ASC;
import static pl.coherentSolutions.store.constant.XmlKey.DESC;

public class SortHelper {
    Store store;

    public List<Product> getProductList() {
        return store.getAllProducts();
    }

    public SortHelper(Store store) {
        this.store = store;
    }

    public List<Product> sortedProductList() {
        List<Product> allProduct = store.getAllProducts();
        Map<String, String> sortConfigFromXml = sortByXml();
        List<Comparator<Product>> comparatorList = new ArrayList<>();
        for (Map.Entry<String, String> entry : sortConfigFromXml.entrySet()) {
            switch (entry.getKey()) {
                case "name":
                    if (entry.getValue().equals(ASC)) {
                        comparatorList.add(Comparator.comparing(Product::getName, String::compareToIgnoreCase));
                    } else if (entry.getValue().equals(DESC)) {
                        comparatorList.add(Comparator.comparing(Product::getName, String::compareToIgnoreCase).reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                case "price":
                    if (entry.getValue().equals(ASC)) {
                        comparatorList.add(Comparator.comparing(Product::getPrice));
                    } else if (entry.getValue().equals(DESC)) {
                        comparatorList.add(Comparator.comparing(Product::getPrice).reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                case "rate":
                    if (entry.getValue().equals(ASC)) {
                        comparatorList.add(Comparator.comparing(Product::getRate));
                    } else if (entry.getValue().equals(DESC)) {
                        comparatorList.add(Comparator.comparing(Product::getRate).reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected sorting value");
            }
        }
        allProduct.sort(getGeneralComparator(comparatorList));
        return allProduct;
    }

    private Comparator<Product> getGeneralComparator(List<Comparator<Product>> comparatorList) {
        Comparator<Product> generalComparator = comparatorList.get(0);
        for (int i = 1; i < comparatorList.size(); i++) {
            generalComparator.thenComparing(comparatorList.get(i));
        }
        return generalComparator;
    }

    private Map<String, String> sortByXml() {
        XmlParser parser = new XmlParser();
        return parser.getSortConfigFromXml();
    }

    public List<Product> topExpensiveProduct(int amount) {
        List<Product> allProduct = store.getAllProducts();
        allProduct.sort(Comparator.comparing(Product::getPrice).reversed());
        return allProduct.stream().limit(amount).collect(Collectors.toList());
    }

    public void printListProduct(List<Product> productList) {
        productList.forEach(System.out::println);
    }
}
