package pl.coherentSolutions.consoleApp;

import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.Interaction;
import pl.coherentSolutions.store.utils.SortHelper;
import pl.coherentSolutions.store.utils.StoreHelper;

public class StoreApp {
    public static void main(String[] args) {

        Store store = new Store();

        StoreHelper storeHelper = new StoreHelper(store);
        SortHelper sortHelper = new SortHelper(store);

        storeHelper.fillStoreRandomly();
        sortHelper.printListProduct(sortHelper.getProductList());

        Interaction interaction = new Interaction(sortHelper);
        interaction.runInteraction();
    }
}
