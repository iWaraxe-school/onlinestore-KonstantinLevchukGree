package pl.coherentSolutions.store.utils.comporators;

import pl.coherentSolutions.products.Product;

import java.util.Comparator;

public class RateComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Double.compare(product1.getRate(), product2.getRate());
    }
}
