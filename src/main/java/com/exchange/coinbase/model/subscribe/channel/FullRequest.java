package com.exchange.coinbase.model.subscribe.channel;

public class FullRequest extends ProductChannelRequest {

  public FullRequest() {
  }

  public FullRequest(String... productIds) {
    super(productIds);
  }

  @Override
  public String toString() {
    return "FullRequest{" +
        "productIds=" + productIds +
        '}';
  }
}
