package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderSide;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.Instant;

public class ActivateMessage extends SequenceMessage {
  private String productId;
  private Instant timestamp;
  private String userId;
  private String profileId;
  private String orderId;
  private String stopType;
  private OrderSide side;
  private BigDecimal stopPrice;
  private BigDecimal size;
  private BigDecimal funds;
  private boolean isPrivate;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getStopType() {
    return stopType;
  }

  public void setStopType(String stopType) {
    this.stopType = stopType;
  }

  public OrderSide getSide() {
    return side;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  public BigDecimal getStopPrice() {
    return stopPrice;
  }

  public void setStopPrice(BigDecimal stopPrice) {
    this.stopPrice = stopPrice;
  }

  public BigDecimal getSize() {
    return size;
  }

  public void setSize(BigDecimal size) {
    this.size = size;
  }

  public BigDecimal getFunds() {
    return funds;
  }

  public void setFunds(BigDecimal funds) {
    this.funds = funds;
  }

  @JsonProperty("private")
  public boolean isPrivate() {
    return isPrivate;
  }

  public void setPrivate(boolean aPrivate) {
    isPrivate = aPrivate;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ActivateMessage{");
    sb.append("productId='").append(productId).append('\'');
    sb.append(", timestamp=").append(timestamp);
    sb.append(", userId='").append(userId).append('\'');
    sb.append(", profileId='").append(profileId).append('\'');
    sb.append(", orderId='").append(orderId).append('\'');
    sb.append(", stopType='").append(stopType).append('\'');
    sb.append(", side=").append(side);
    sb.append(", stopPrice=").append(stopPrice);
    sb.append(", size=").append(size);
    sb.append(", funds=").append(funds);
    sb.append(", isPrivate=").append(isPrivate);
    sb.append('}');
    return sb.toString();
  }
}
