package com.exchange.coinbase.model.order;

import com.exchange.coinbase.model.market.OrderSide;
import java.math.BigDecimal;
import java.time.Instant;

public class OrderStatus {
  private String id;
  private BigDecimal price;
  private BigDecimal size;
  private String productId;
  private String profileId;
  private OrderSide side;
  private OrderType type;
  private TimeInForce timeInForce;
  private boolean postOnly;
  private Instant createdAt;
  private BigDecimal fillFees;
  private BigDecimal filledSize;
  private BigDecimal executedValue;
  private String status = "open";
  private boolean settled;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
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

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public void setTimeInForce(TimeInForce timeInForce) {
    this.timeInForce = timeInForce;
  }

  public boolean isPostOnly() {
    return postOnly;
  }

  public void setPostOnly(boolean postOnly) {
    this.postOnly = postOnly;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public BigDecimal getFillFees() {
    return fillFees;
  }

  public void setFillFees(BigDecimal fillFees) {
    this.fillFees = fillFees;
  }

  public BigDecimal getFilledSize() {
    return filledSize;
  }

  public void setFilledSize(BigDecimal filledSize) {
    this.filledSize = filledSize;
  }

  public BigDecimal getExecutedValue() {
    return executedValue;
  }

  public void setExecutedValue(BigDecimal executedValue) {
    this.executedValue = executedValue;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public boolean isSettled() {
    return settled;
  }

  public void setSettled(boolean settled) {
    this.settled = settled;
  }

  @Override
  public String toString() {
    return "OrderStatus{" +
        "id='" + id + '\'' +
        ", price=" + price +
        ", size=" + size +
        ", productId='" + productId + '\'' +
        ", profileId='" + profileId + '\'' +
        ", side=" + side +
        ", type=" + type +
        ", timeInForce=" + timeInForce +
        ", postOnly=" + postOnly +
        ", createdAt=" + createdAt +
        ", fillFees=" + fillFees +
        ", filledSize=" + filledSize +
        ", executedValue=" + executedValue +
        ", status='" + status + '\'' +
        ", settled=" + settled +
        '}';
  }
}
