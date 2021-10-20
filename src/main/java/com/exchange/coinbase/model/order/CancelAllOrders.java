package com.exchange.coinbase.model.order;

public class CancelAllOrders {
  private String profileId;
  private String productId;

  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Override
  public String toString() {
    return "CancelAllOrders{" +
        "profileId='" + profileId + '\'' +
        ", productId='" + productId + '\'' +
        '}';
  }
}
