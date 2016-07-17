package io.vertx.sample.metrics;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;

public class HttpClientVerticle extends AbstractVerticle {

  private HttpClient client;

  @Override
  public void start() throws Exception {
    client = vertx.createHttpClient();

    vertx.setPeriodic(5000, l ->
      client.getNow(8080, "localhost", "/",
          response -> response.bodyHandler(
              buffer -> System.out.println("[HTTP Client] " + "received '" + buffer.toString() + "'")
          ))
    );
  }

  @Override
  public void stop() throws Exception {
    if (client != null) {
      client.close();
    }
  }
}
