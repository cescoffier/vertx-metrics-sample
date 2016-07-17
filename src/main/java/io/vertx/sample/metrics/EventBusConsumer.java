package io.vertx.sample.metrics;

import io.vertx.core.AbstractVerticle;

import java.util.Random;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class EventBusConsumer extends AbstractVerticle {

  private Random random = new Random();

  @Override
  public void start() throws Exception {
    vertx.eventBus().consumer("an-address", message -> {
      if (random.nextBoolean() && random.nextBoolean()) {
        // Simulate a failure - does not reply to the message
      } else {
        message.reply(message.body() + " world !");
      }
    });
  }
}
