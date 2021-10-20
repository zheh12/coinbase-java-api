package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderSide;
import java.math.BigDecimal;
import java.time.Instant;

public class TickerMessage extends SequenceMessage {
  private long tradeId;
  private Instant time;
  private String productId;
  private BigDecimal price;
  private OrderSide side;
  private BigDecimal lastSize;
  private BigDecimal bestBid;
  private BigDecimal bestAsk;

  public long getTradeId() {
    return tradeId;
  }

  public void setTradeId(long tradeId) {
    this.tradeId = tradeId;
  }

  public Instant getTime() {
    return time;
  }

  public void setTime(Instant time) {
    this.time = time;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public OrderSide getSide() {
    return side;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  public BigDecimal getLastSize() {
    return lastSize;
  }

  public void setLastSize(BigDecimal lastSize) {
    this.lastSize = lastSize;
  }

  public BigDecimal getBestBid() {
    return bestBid;
  }

  public void setBestBid(BigDecimal bestBid) {
    this.bestBid = bestBid;
  }

  public BigDecimal getBestAsk() {
    return bestAsk;
  }

  public void setBestAsk(BigDecimal bestAsk) {
    this.bestAsk = bestAsk;
  }

  @Override
  public String toString() {
    return "TickerMessage{" +
        "tradeId=" + tradeId +
        ", time=" + time +
        ", productId='" + productId + '\'' +
        ", price=" + price +
        ", side=" + side +
        ", lastSize=" + lastSize +
        ", bestBid=" + bestBid +
        ", bestAsk=" + bestAsk +
        '}';
  }
}
