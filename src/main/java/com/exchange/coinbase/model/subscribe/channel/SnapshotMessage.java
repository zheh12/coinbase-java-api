package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderbookEntry;
import com.exchange.coinbase.model.subscribe.Message;
import java.util.List;

public class SnapshotMessage extends Message {
  private String productId;
  private List<OrderbookEntry> bids;
  private List<OrderbookEntry> asks;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public List<OrderbookEntry> getBids() {
    return bids;
  }

  public void setBids(List<OrderbookEntry> bids) {
    this.bids = bids;
  }

  public List<OrderbookEntry> getAsks() {
    return asks;
  }

  public void setAsks(List<OrderbookEntry> asks) {
    this.asks = asks;
  }

  @Override
  public String toString() {
    return "SnapshotMessage{" +
        "productId='" + productId + '\'' +
        ", bids=" + bids +
        ", asks=" + asks +
        '}';
  }
}
