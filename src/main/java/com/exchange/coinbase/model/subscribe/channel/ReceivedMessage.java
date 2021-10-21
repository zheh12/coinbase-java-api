package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderSide;
import com.exchange.coinbase.model.order.OrderType;
import java.math.BigDecimal;
import java.time.Instant;

public class ReceivedMessage extends SequenceMessage {
  private Instant time;
  private String productId;
  private String orderId;
  private BigDecimal size;
  private BigDecimal price;
  private OrderSide side;
  private OrderType type;

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

  public BigDecimal getSize() {
    return size;
  }

  public void setSize(BigDecimal size) {
    this.size = size;
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

  public OrderType getType() {
    return type;
  }

  public void setType(OrderType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ReceivedMessage{");
    sb.append("time=").append(time);
    sb.append(", productId='").append(productId).append('\'');
    sb.append(", orderId='").append(orderId).append('\'');
    sb.append(", size=").append(size);
    sb.append(", price=").append(price);
    sb.append(", side=").append(side);
    sb.append(", type=").append(type);
    sb.append('}');
    return sb.toString();
  }
}
