package pl.coherentSolutions.store.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SortKey {
    NAME("name"),
    PRICE("price"),
    RATE("rate");

    private final String getKey;

    public String getKey() {
        return getKey;
    }
}
