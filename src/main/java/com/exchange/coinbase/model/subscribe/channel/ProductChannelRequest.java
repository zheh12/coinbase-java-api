package com.exchange.coinbase.model.subscribe.channel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ProductChannelRequest extends ChannelRequest {
  protected List<String> productIds;

  public ProductChannelRequest() {
    this.productIds = new ArrayList<>();
  }

  public ProductChannelRequest(String... productIds) {
    this.productIds = Arrays.asList(productIds);
  }

  public List<String> getProductIds() {
    return productIds;
  }

  public void setProductIds(List<String> productIds) {
    this.productIds = productIds;
  }
}
