package pl.coherentSolutions.store.http;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
public class Server {

    private static HttpServer server;
    public static final String REALM = "Categories and Cart";

    @SneakyThrows
    public void createHttpServer() {

        log.info("HttpServer create");
        server = HttpServer.create(new InetSocketAddress(8080), 0);

        HttpServerName httpServerName = new HttpServerName();
        httpServerName.createNameServer(server, "My server");

        HttpContext categoryHandler = server.createContext("/categories", new HttpCategoryHandler());
        HttpContext cartHandler = server.createContext("/cart", new HttpCartHandler());

        categoryHandler.setAuthenticator(new HttpAuthenticator(REALM));
        cartHandler.setAuthenticator(new HttpAuthenticator(REALM));
        //Create a default executor
        server.setExecutor(null);

    }

    public void start() {
        server.start();
        log.info("HttpServer started");
    }

    public void stop() {
        server.stop(0);
        log.info("HttpServer stopped");
    }
}

