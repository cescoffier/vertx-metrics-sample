package io.vertx.sample.metrics;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HttpServerVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    Router router = Router.router(vertx);
    router.get("/").handler(rc -> {
      rc.response().end("Hello World !");
    });
    router.get("/health").handler(rc -> {
      rc.response().end("OK");
    });

    vertx.createHttpServer()
        .requestHandler(router::accept)
        .listen(8080);
  }
}
