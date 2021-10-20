package com.exchange.coinbase;

import java.util.concurrent.TimeUnit;

public class RateLimit {
  private long limit;
  private TimeUnit timeUnit;

  public RateLimit(long limit, TimeUnit timeUnit) {
    this.limit = limit;
    this.timeUnit = timeUnit;
  }

  public static RateLimit seconds(long number) {
    return new RateLimit(number, TimeUnit.SECONDS);
  }

  public static RateLimit defaultRateLimit() {
    return new RateLimit(10, TimeUnit.SECONDS);
  }

  public static RateLimit defaultBurstsRateLimit() {
    return new RateLimit(15, TimeUnit.SECONDS);
  }
}
