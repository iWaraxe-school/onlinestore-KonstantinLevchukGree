package pl.coherentSolutions.consoleApp;

import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.StoreHelper;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        StoreHelper helper = new StoreHelper(store);
        helper.fillStoreRandomly();
        store.printStore();

        int a = 0;
    }
}
