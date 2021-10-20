package com.exchange.coinbase.model.market;

public enum CandleInterval {
  INTERVAL_1M(60), INTERVAL_5M(300),
  INTERVAL_15M(900), INTERVAL_1H(3600),
  INTERVAL_6H(21600), INTERVAL_1d(86400);

  private long time;

  CandleInterval(long time) {
    this.time = time;
  }

  public long getTime() {
    return time;
  }
}
