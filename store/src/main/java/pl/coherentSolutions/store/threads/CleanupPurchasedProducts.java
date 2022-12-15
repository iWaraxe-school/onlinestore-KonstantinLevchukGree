package pl.coherentSolutions.store.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.store.Store;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CleanupPurchasedProducts extends Thread {

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            log.info("Thread is running, name: "+Thread.currentThread().getName());
            TimeUnit.MINUTES.sleep(2);
            log.info("Start cleanup purchased Product");
            cleanupPurchasedProductsStore();
            if(Store.purchasedProducts.size()==0){
                log.info("Cleaning done");
            }
            else {log.info("Cleaning failed");}
            log.info("Clean purchased Products ended");
        }
    }

    private void cleanupPurchasedProductsStore() {
        Store.purchasedProducts.clear();
    }
}
