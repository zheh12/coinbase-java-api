package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderSide;
import java.math.BigDecimal;
import java.time.Instant;

public class DoneMessage extends SequenceMessage {
  private Instant time;
  private String productId;
  private BigDecimal price;
  private String orderId;
  private String reason;
  private OrderSide side;
  private BigDecimal remainingSize;

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

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public OrderSide getSide() {
    return side;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  public BigDecimal getRemainingSize() {
    return remainingSize;
  }

  public void setRemainingSize(BigDecimal remainingSize) {
    this.remainingSize = remainingSize;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("DoneMessage{");
    sb.append("time=").append(time);
    sb.append(", productId='").append(productId).append('\'');
    sb.append(", price=").append(price);
    sb.append(", orderId='").append(orderId).append('\'');
    sb.append(", reason='").append(reason).append('\'');
    sb.append(", side=").append(side);
    sb.append(", remainingSize=").append(remainingSize);
    sb.append('}');
    return sb.toString();
  }
}
