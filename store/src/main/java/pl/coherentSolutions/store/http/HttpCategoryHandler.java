package pl.coherentSolutions.store.http;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.domain.Category;
import pl.coherentSolutions.store.Store;

import java.io.OutputStream;
import java.util.List;

@Slf4j
public class HttpCategoryHandler implements HttpHandler {
    @SneakyThrows
    @Override
    public void handle(HttpExchange httpExchange) {
        Store store = Store.getInstance();
        List<Category> categories = store.getCategoryList();
        Gson gson = new Gson();
        gson.toJson(categories);
        httpExchange.sendResponseHeaders(200, gson.toJson(categories).length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(gson.toJson(categories).getBytes());
        outputStream.close();
        log.info("Categories added in Http server");
    }
}
