package com.demo;

import io.undertow.Undertow;
import io.undertow.util.Headers;

/**
 * Hello world!
 * Returns a simple web page on port 8080.
 */
public class App {

    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                // Set up the listener - you can change the port/host here
                .addHttpListener(8080, "0.0.0.0")

                .setHandler(exchange -> {
                    // Sets the return Content-Type to text/html
                    exchange.getResponseHeaders()
                            .put(Headers.CONTENT_TYPE, "text/html");

                    // Returns a hard-coded HTML document
                    exchange.getResponseSender()
                            .send("Hello");
                }).build();

        // Boot the web server
        server.start();
    }
}