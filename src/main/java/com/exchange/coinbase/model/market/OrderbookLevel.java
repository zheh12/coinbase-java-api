package com.exchange.coinbase.model.market;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;

public enum OrderbookLevel {

  BID_ASK(1),
  FULL_AGG_ORDER_BOOK(2),
  FULL_ORDER_BOOK(3);

  private final int level;

  OrderbookLevel(int level) {
    this.level = level;
  }

  public int level() {
    return level;
  }

  @JsonCreator
  public static OrderbookLevel createLevel(int level) {
    return Arrays.stream(OrderbookLevel.values()).filter(x -> x.level == level)
        .findFirst()
        .get();
  }
}
