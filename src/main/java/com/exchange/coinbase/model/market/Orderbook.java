package com.exchange.coinbase.model.market;

import java.util.List;

public class Orderbook {
  private long sequence;
  private List<OrderbookEntry> bids;
  private List<OrderbookEntry> asks;

  public long getSequence() {
    return sequence;
  }

  public void setSequence(long sequence) {
    this.sequence = sequence;
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
    return "Orderbook{" +
        "sequence=" + sequence +
        ", bids=" + bids +
        ", asks=" + asks +
        '}';
  }
}
