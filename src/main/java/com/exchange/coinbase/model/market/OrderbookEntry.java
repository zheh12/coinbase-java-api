package com.exchange.coinbase.model.market;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.math.BigDecimal;

@JsonFormat(shape = Shape.ARRAY)
public class OrderbookEntry {
  private BigDecimal price;
  private BigDecimal amount;
  private String auction;

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getAuction() {
    return auction;
  }

  public void setAuction(String auction) {
    this.auction = auction;
  }

  @Override
  public String toString() {
    return "OrderbookEntry{" +
        "price=" + price +
        ", amount=" + amount +
        ", auction=" + auction +
        '}';
  }
}
