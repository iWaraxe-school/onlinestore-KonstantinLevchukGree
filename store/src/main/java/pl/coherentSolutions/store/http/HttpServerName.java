package pl.coherentSolutions.store.http;

import com.sun.net.httpserver.HttpServer;
import lombok.extern.slf4j.Slf4j;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class HttpServerName {
    public void createNameServer(HttpServer server, String nameServer) {
        server.createContext("/", httpExchange ->
        {
            byte[] response = nameServer.getBytes(StandardCharsets.UTF_8);
            httpExchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
            httpExchange.sendResponseHeaders(200, response.length);

            OutputStream out = httpExchange.getResponseBody();
            out.write(response);
            out.close();
        });
        log.info("Name server created");
    }
}

