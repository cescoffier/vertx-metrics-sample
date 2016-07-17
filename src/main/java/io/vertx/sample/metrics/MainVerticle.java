package io.vertx.sample.metrics;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.deployVerticle(EventBusConsumer.class.getName());
    vertx.deployVerticle(EventBusProducer.class.getName());
    vertx.deployVerticle(HttpServerVerticle.class.getName());
    vertx.deployVerticle(HttpClientVerticle.class.getName());
  }
}