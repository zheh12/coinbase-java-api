package com.exchange.coinbase.model.subscribe.channel;

public class Level2Request extends ProductChannelRequest {

  public Level2Request() {
  }

  public Level2Request(String... productIds) {
    super(productIds);
  }

  @Override
  public String toString() {
    return "Level2Request{" +
        "productIds=" + productIds +
        '}';
  }
}
