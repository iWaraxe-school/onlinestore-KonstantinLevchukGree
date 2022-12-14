package pl.coherentSolutions.consoleApp;


import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.Interaction;
import pl.coherentSolutions.store.utils.SortHelper;
import pl.coherentSolutions.store.utils.StoreHelper;

@Slf4j

public class StoreApp {

    public static void main(String[] args) {

        log.info("Thread Main");
        Store store = Store.getInstance();

        StoreHelper storeHelper = new StoreHelper(store);
        SortHelper sortHelper = new SortHelper(store);

        storeHelper.fillStoreRandomly();
        sortHelper.printListProduct(sortHelper.getProductList());

        Interaction interaction = new Interaction(sortHelper);
        interaction.runInteraction();

    }
}
