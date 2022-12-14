package pl.coherentSolutions.store.threads;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class CreateOrder extends Thread {

    private final List<Product> selectedProducts;

    @SneakyThrows
    @Override
    public void run() {
        log.info("CreateOrder started");
        int threadSleep = new Random().nextInt(30);
        log.info("Wait " + threadSleep + " seconds");
        TimeUnit.SECONDS.sleep(threadSleep);
        Store.purchasedProducts.addAll(0, selectedProducts);
        log.info("Products added Order");
        Store.getPurchasedProducts().forEach(System.out::println);
        log.info("CreateOrder ended");
    }
}
