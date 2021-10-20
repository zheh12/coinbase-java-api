package com.exchange.coinbase.model.market;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderSide {
  @JsonProperty("buy")
  BUY,
  @JsonProperty("sell")
  SELL;
}
