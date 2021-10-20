package com.exchange.coinbase.model.subscribe.channel;

public class TickerRequest extends ProductChannelRequest {

  public TickerRequest() {
  }

  public TickerRequest(String... productIds) {
    super(productIds);
  }

  @Override
  public String toString() {
    return "TickerRequest{" +
        "productIds=" + productIds +
        '}';
  }
}
