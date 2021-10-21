package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderSide;
import java.math.BigDecimal;
import java.time.Instant;

public class OpenMessage extends SequenceMessage {
  private Instant time;
  private String productId;
  private String orderId;
  private BigDecimal price;
  private BigDecimal remainingSize;
  private OrderSide side;

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

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getRemainingSize() {
    return remainingSize;
  }

  public void setRemainingSize(BigDecimal remainingSize) {
    this.remainingSize = remainingSize;
  }

  public OrderSide getSide() {
    return side;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("OpenMessage{");
    sb.append("time=").append(time);
    sb.append(", productId='").append(productId).append('\'');
    sb.append(", orderId='").append(orderId).append('\'');
    sb.append(", price=").append(price);
    sb.append(", remainingSize=").append(remainingSize);
    sb.append(", side=").append(side);
    sb.append('}');
    return sb.toString();
  }
}
