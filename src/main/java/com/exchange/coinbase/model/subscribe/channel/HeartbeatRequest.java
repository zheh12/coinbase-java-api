package com.exchange.coinbase.model.subscribe.channel;

public class HeartbeatRequest extends ProductChannelRequest {

  public HeartbeatRequest() {
  }

  public HeartbeatRequest(String... productIds) {
    super(productIds);
  }

  @Override
  public String toString() {
    return "HeartbeatRequest{" +
        "productIds=" + productIds +
        '}';
  }
}
