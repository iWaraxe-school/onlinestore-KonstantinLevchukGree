package pl.coherentSolutions.consoleApp;


import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.threads.CleanupPurchasedProducts;
import pl.coherentSolutions.store.utils.Interaction;
import pl.coherentSolutions.store.utils.SortHelper;
import pl.coherentSolutions.store.utils.StoreHelper;

@Slf4j

public class StoreApp {

    public static void main(String[] args) {

        log.info("Start new thread, name: "+Thread.currentThread().getName());
        Store store = Store.getInstance();

        log.info("Start new thread");
        new CleanupPurchasedProducts().start();

        StoreHelper storeHelper = new StoreHelper(store);
        SortHelper sortHelper = new SortHelper(store);

        storeHelper.fillStoreRandomly();
        sortHelper.printListProduct(sortHelper.getProductList());

        Interaction interaction = new Interaction(sortHelper);
        interaction.runInteraction();
    }
}
