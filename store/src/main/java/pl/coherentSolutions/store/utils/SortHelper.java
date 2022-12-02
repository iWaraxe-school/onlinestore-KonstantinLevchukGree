package pl.coherentSolutions.store.utils;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.constant.XmlKey;
import pl.coherentSolutions.store.utils.comporators.NameComparator;
import pl.coherentSolutions.store.utils.comporators.PriceComparator;
import pl.coherentSolutions.store.utils.comporators.RateComparator;

import java.util.List;
import java.util.Map;

public class SortHelper {
    Store store;


    public SortHelper(Store store) {
        this.store = store;
    }

    public List<Product> sortedProductList(Map<String, String> sortConfigFromXml, String value) {
        List<Product> allProduct = store.getAllProducts();
        for (Map.Entry<String, String> entry : sortConfigFromXml.entrySet()) {
            switch (value) {
                case "name":
                    if (entry.getValue().equals(XmlKey.asc)) {
                        allProduct.sort(new NameComparator());
                    } else if (entry.getValue().equals(XmlKey.desc)) {
                        allProduct.sort(new NameComparator().reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                case "price":
                    if (entry.getValue().equals(XmlKey.asc)) {
                        allProduct.sort(new PriceComparator());
                    } else if (entry.getValue().equals(XmlKey.desc)) {
                        allProduct.sort(new PriceComparator().reversed());
                    } else {
                        throw new IllegalStateException("Sort value is not in the file XML");
                    }
                    break;
                case "rate":
                    if (entry.getValue().equals(XmlKey.asc)) {
                        allProduct.sort(new RateComparator());
                    } else if (entry.getValue().equals(XmlKey.desc)) {
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
        System.out.println(configMap);
        return sortedProductList(configMap, value);
    }
}
