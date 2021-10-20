package com.exchange.coinbase.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderType {
  @JsonProperty("limit")
  LIMIT,
  @JsonProperty("market")
  MARKET
}
