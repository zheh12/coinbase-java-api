package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.subscribe.Message;
import java.time.Instant;
import java.util.List;

public class Level2UpdateMessage extends Message {
  private String productId;
  private Instant time;
  private List<Level2Change> changes;

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

  public List<Level2Change> getChanges() {
    return changes;
  }

  public void setChanges(
      List<Level2Change> changes) {
    this.changes = changes;
  }

  @Override
  public String toString() {
    return "Level2UpdateMessage{" +
        "productId='" + productId + '\'' +
        ", time=" + time +
        ", changes=" + changes +
        '}';
  }
}
