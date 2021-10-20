package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderSide;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.math.BigDecimal;

@JsonFormat(shape = Shape.ARRAY)
public class Level2Change {
  private OrderSide side;
  private BigDecimal price;
  private BigDecimal size;

  public OrderSide getSide() {
    return side;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getSize() {
    return size;
  }

  public void setSize(BigDecimal size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Level2Change{" +
        "side=" + side +
        ", price=" + price +
        ", quantity=" + size +
        '}';
  }
}
