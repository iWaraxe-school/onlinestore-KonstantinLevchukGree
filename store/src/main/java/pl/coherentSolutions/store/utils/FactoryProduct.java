package pl.coherentSolutions.store.utils;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.constant.ProductType;

import java.util.HashMap;
import java.util.Map;

public class FactoryProduct {

    public static Product getProduct(String categoryName) {
        return getProductMap().get(categoryName);
    }

    //Factory
    public static Map<String, Product> getProductMap() {
        Map<String, Product> productTypeMap = new HashMap<>();
        productTypeMap.put(ProductType.BIKE.getKey(), Product.newProductBuilder()
                .setName(FakerProduct.getProductNameBike())
                .setPrice(FakerProduct.getProductPrice())
                .setRate(FakerProduct.getProductRate())
                .build());
        productTypeMap.put(ProductType.MILK.getKey(), Product.newProductBuilder()
                .setName(FakerProduct.getProductNameMilk())
                .setPrice(FakerProduct.getProductPrice())
                .setRate(FakerProduct.getProductRate())
                .build());
        productTypeMap.put(ProductType.PHONE.getKey(), Product.newProductBuilder()
                .setName(FakerProduct.getProductNamePhone())
                .setPrice(FakerProduct.getProductPrice())
                .setRate(FakerProduct.getProductRate())
                .build());
        return productTypeMap;
    }
}
