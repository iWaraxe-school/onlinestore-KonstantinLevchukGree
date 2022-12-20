package pl.coherentSolutions.consoleApp;

import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.DBHelper;
import pl.coherentSolutions.store.utils.StoreHelper;

@Slf4j

public class StoreApp {

    public static void main(String[] args) {
        log.info("Start new thread, name: " + Thread.currentThread().getName());
        Store store = Store.getInstance();

        log.info("Start new thread");
        // new CleanupPurchasedProducts().start();

        StoreHelper storeHelper = new StoreHelper(store);
        //SortHelper sortHelper = new SortHelper(store);
        storeHelper.fillStoreRandomly();
        //sortHelper.printListProduct(sortHelper.getProductList());

        //Interaction interaction = new Interaction(sortHelper);
        //interaction.runInteraction();

        DBHelper dbHelper = new DBHelper();
        dbHelper.connectDB();
        dbHelper.createCategoryTable();
        dbHelper.createProductTable();
        dbHelper.addProductsToDataBase();
        dbHelper.printProductsFromDataBase();
        dbHelper.clearDB();
        dbHelper.closeConnection();
    }
}
