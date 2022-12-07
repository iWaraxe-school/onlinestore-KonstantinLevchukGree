package pl.coherentSolutions.store.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum CommandKey {

    SORT("sort"),
    TOP("top"),
    QUIT("quit");

    private final String getKey;

    public String getKey() {
        return getKey;
    }
}
