package io.vertx.sample.metrics;

import io.vertx.core.Launcher;
import io.vertx.core.VertxOptions;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class Application extends Launcher {

  public static void main(String[] args) {
    Application application = new Application();
    application.dispatch(args);
  }

  @Override
  public void beforeStartingVertx(VertxOptions options) {
    // Customize metrics options
    DropwizardMetricsOptions metrics = new DropwizardMetricsOptions()
        .setJmxDomain("vertx")
        .setJmxEnabled(true)
        .setEnabled(true);

    options
        .setMetricsOptions(metrics);
  }
}
