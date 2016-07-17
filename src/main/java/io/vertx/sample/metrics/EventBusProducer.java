package io.vertx.sample.metrics;

import io.vertx.core.AbstractVerticle;

public class EventBusProducer extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    vertx.setPeriodic(5000, l -> {
      vertx.eventBus().send("an-address", "hello", reply -> {
         if (reply.failed()) {
           System.out.println("[Eventbus Producer] " + " reply failure '" + reply.cause().getMessage() + "'");
         } else {
           System.out.println("[Eventbus Producer] " + " reply: '" + reply.result().body() + "'");
         }
      });
    });
  }
}
