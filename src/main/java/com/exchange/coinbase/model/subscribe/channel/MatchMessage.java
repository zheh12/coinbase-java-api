package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.OrderSide;
import java.math.BigDecimal;
import java.time.Instant;

public class MatchMessage extends SequenceMessage {
  private long tradeId;
  private String makerOrderId;
  private String takerOrderId;
  private Instant time;
  private String productId;
  private BigDecimal size;
  private BigDecimal price;
  private OrderSide side;
  private String takerUserId;
  private String userId;
  private String takerProfileId;
  private String profileId;
  private String takerFeeRate;
  private String makerUserId;
  private String makerProfileId;
  private String makerFeeRate;

  public long getTradeId() {
    return tradeId;
  }

  public String getTakerUserId() {
    return takerUserId;
  }

  public void setTakerUserId(String takerUserId) {
    this.takerUserId = takerUserId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getTakerProfileId() {
    return takerProfileId;
  }

  public void setTakerProfileId(String takerProfileId) {
    this.takerProfileId = takerProfileId;
  }

  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public String getTakerFeeRate() {
    return takerFeeRate;
  }

  public void setTakerFeeRate(String takerFeeRate) {
    this.takerFeeRate = takerFeeRate;
  }

  public String getMakerUserId() {
    return makerUserId;
  }

  public void setMakerUserId(String makerUserId) {
    this.makerUserId = makerUserId;
  }

  public String getMakerProfileId() {
    return makerProfileId;
  }

  public void setMakerProfileId(String makerProfileId) {
    this.makerProfileId = makerProfileId;
  }

  public String getMakerFeeRate() {
    return makerFeeRate;
  }

  public void setMakerFeeRate(String makerFeeRate) {
    this.makerFeeRate = makerFeeRate;
  }

  public void setTradeId(long tradeId) {
    this.tradeId = tradeId;
  }

  public String getMakerOrderId() {
    return makerOrderId;
  }

  public void setMakerOrderId(String makerOrderId) {
    this.makerOrderId = makerOrderId;
  }

  public String getTakerOrderId() {
    return takerOrderId;
  }

  public void setTakerOrderId(String takerOrderId) {
    this.takerOrderId = takerOrderId;
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

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("MatchMessage{");
    sb.append("tradeId=").append(tradeId);
    sb.append(", makerOrderId='").append(makerOrderId).append('\'');
    sb.append(", takerOrderId='").append(takerOrderId).append('\'');
    sb.append(", time=").append(time);
    sb.append(", productId='").append(productId).append('\'');
    sb.append(", size=").append(size);
    sb.append(", price=").append(price);
    sb.append(", side=").append(side);
    sb.append(", takerUserId='").append(takerUserId).append('\'');
    sb.append(", userId='").append(userId).append('\'');
    sb.append(", takerProfileId='").append(takerProfileId).append('\'');
    sb.append(", profileId='").append(profileId).append('\'');
    sb.append(", takerFeeRate='").append(takerFeeRate).append('\'');
    sb.append(", makerUserId='").append(makerUserId).append('\'');
    sb.append(", makerProfileId='").append(makerProfileId).append('\'');
    sb.append(", makerFeeRate='").append(makerFeeRate).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
