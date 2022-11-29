package pl.coherentSolutions.store.utils;

import com.github.javafaker.Faker;

public class RandomStorePopulator {
    private final Faker faker = new Faker();

    public String getProductName(String categoryName) {
        switch (categoryName) {
            case "Bike":
                return faker.esports().game();
            case "Milk":
                return faker.food().ingredient();
            case "Phone":
                return faker.funnyName().name();
            default:
                return "Unknown category";
        }
    }

    public Double getProductPrice() {
        return faker.number().randomDouble(2, 1, 10000);
    }

    public Double getProductRate() {
        return faker.number().randomDouble(1, 1, 100);
    }

}
