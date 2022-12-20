package pl.coherentSolutions.store.utils;

import com.github.javafaker.Faker;

public class FakerProduct {

    private static final Faker faker = new Faker();

    public static String getProductNameBike() {
        return faker.esports().game();
    }

    public static String getProductNameMilk() {
        return faker.food().ingredient();
    }

    public static String getProductNamePhone() {
        return faker.funnyName().name();
    }

    public static Double getProductPrice() {
        return faker.number().randomDouble(2, 1, 10000);
    }

    public static Double getProductRate() {
        return faker.number().randomDouble(1, 1, 100);
    }
}
