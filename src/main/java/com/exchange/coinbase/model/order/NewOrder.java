package com.exchange.coinbase.model.order;

import com.exchange.coinbase.model.market.OrderSide;
import java.math.BigDecimal;

public class NewOrder {
  private String profileId;
  private OrderType type;
  private OrderSide side;
  private String productId;
  private String stp = "dc";
  private String stop;
  private BigDecimal stopPrice;
  private BigDecimal price;
  private BigDecimal size;
  private BigDecimal funds;
  private TimeInForce timeInForce = TimeInForce.GTC;
  private String cancelAfter;
  private Boolean postOnly = false;
  private String clientOid;

  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public OrderType getType() {
    return type;
  }

  public void setType(OrderType type) {
    this.type = type;
  }

  public OrderSide getSide() {
    return side;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getStp() {
    return stp;
  }

  public void setStp(String stp) {
    this.stp = stp;
  }

  public String getStop() {
    return stop;
  }

  public void setStop(String stop) {
    this.stop = stop;
  }

  public BigDecimal getStopPrice() {
    return stopPrice;
  }

  public void setStopPrice(BigDecimal stopPrice) {
    this.stopPrice = stopPrice;
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

  public BigDecimal getFunds() {
    return funds;
  }

  public void setFunds(BigDecimal funds) {
    this.funds = funds;
  }

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public void setTimeInForce(TimeInForce timeInForce) {
    this.timeInForce = timeInForce;
  }

  public String getCancelAfter() {
    return cancelAfter;
  }

  public void setCancelAfter(String cancelAfter) {
    this.cancelAfter = cancelAfter;
  }

  public Boolean getPostOnly() {
    return postOnly;
  }

  public void setPostOnly(Boolean postOnly) {
    this.postOnly = postOnly;
  }

  public String getClientOid() {
    return clientOid;
  }

  public void setClientOid(String clientOid) {
    this.clientOid = clientOid;
  }

  @Override
  public String toString() {
    return "NewOrder{" +
        "profileId='" + profileId + '\'' +
        ", type=" + type +
        ", side=" + side +
        ", productId='" + productId + '\'' +
        ", stp='" + stp + '\'' +
        ", stop='" + stop + '\'' +
        ", stopPrice=" + stopPrice +
        ", price=" + price +
        ", size=" + size +
        ", funds=" + funds +
        ", timeInForce=" + timeInForce +
        ", cancelAfter='" + cancelAfter + '\'' +
        ", postOnly=" + postOnly +
        ", clientOid='" + clientOid + '\'' +
        '}';
  }
}
