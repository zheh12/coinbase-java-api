package com.exchange.coinbase.model.subscribe.channel;

import java.time.Instant;

public class HeartbeatMessage extends SequenceMessage {
  private long lastTradeId;
  private String productId;
  private Instant time;

  public long getLastTradeId() {
    return lastTradeId;
  }

  public void setLastTradeId(long lastTradeId) {
    this.lastTradeId = lastTradeId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Instant getTime() {
    return time;
  }

  public void setTime(Instant time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "HeartbeatMessage{" +
        "lastTradeId=" + lastTradeId +
        ", productId='" + productId + '\'' +
        ", time=" + time +
        '}';
  }
}
