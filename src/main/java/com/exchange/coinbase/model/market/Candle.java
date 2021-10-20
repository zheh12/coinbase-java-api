package com.exchange.coinbase.model.market;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.math.BigDecimal;
import java.time.Instant;

@JsonFormat(shape = Shape.ARRAY)
public class Candle {
  private Instant timestamp;
  private BigDecimal priceLow;
  private BigDecimal priceHigh;
  private BigDecimal priceOpen;
  private BigDecimal priceClose;

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public BigDecimal getPriceLow() {
    return priceLow;
  }

  public void setPriceLow(BigDecimal priceLow) {
    this.priceLow = priceLow;
  }

  public BigDecimal getPriceHigh() {
    return priceHigh;
  }

  public void setPriceHigh(BigDecimal priceHigh) {
    this.priceHigh = priceHigh;
  }

  public BigDecimal getPriceOpen() {
    return priceOpen;
  }

  public void setPriceOpen(BigDecimal priceOpen) {
    this.priceOpen = priceOpen;
  }

  public BigDecimal getPriceClose() {
    return priceClose;
  }

  public void setPriceClose(BigDecimal priceClose) {
    this.priceClose = priceClose;
  }

  @Override
  public String toString() {
    return "Candle{" +
        "timestamp=" + timestamp +
        ", priceLow=" + priceLow +
        ", priceHigh=" + priceHigh +
        ", priceOpen=" + priceOpen +
        ", priceClose=" + priceClose +
        '}';
  }
}
