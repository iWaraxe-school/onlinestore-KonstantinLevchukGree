package pl.coherentSolutions.consoleApp;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.http.HttpClient;
import pl.coherentSolutions.store.http.Server;
import pl.coherentSolutions.store.utils.SortHelper;
import pl.coherentSolutions.store.utils.StoreHelper;

@Slf4j

public class StoreApp {

    @SneakyThrows
    public static void main(String[] args) {
        log.info("Start new thread, name: " + Thread.currentThread().getName());
        Store store = Store.getInstance();

        StoreHelper storeHelper = new StoreHelper(store);
        SortHelper sortHelper = new SortHelper(store);
        storeHelper.fillStoreRandomly();
        sortHelper.printListProduct(sortHelper.getProductList());

        Server httpServer = new Server();
        httpServer.createHttpServer();
        httpServer.start();

        HttpClient client = new HttpClient();
        client.getProducts();
        client.getProduct();

        httpServer.stop();
    }
}
