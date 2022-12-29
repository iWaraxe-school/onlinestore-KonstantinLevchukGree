package pl.coherentSolutions.store.http;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;

import java.io.OutputStream;
import java.util.Random;

@Slf4j
public class HttpCartHandler implements HttpHandler {

    @SneakyThrows
    @Override
    public void handle(HttpExchange httpExchange) {
        Store store = Store.getInstance();

        //Random purchased Product
        Product purchasedProduct = store.getAllProducts().get(new Random().nextInt(10));
        Gson gson = new Gson();
        gson.toJson(purchasedProduct);
        httpExchange.sendResponseHeaders(200, gson.toJson(purchasedProduct).length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(gson.toJson(purchasedProduct).getBytes());
        outputStream.close();
        log.info("Product added in cart");
    }
}
