package pl.coherentSolutions.store.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum ProductType {
    BIKE("Bike"),
    MILK("Milk"),
    PHONE("Phone");
    private final String getKey;

    public String getKey() {
        return getKey;
    }
}
