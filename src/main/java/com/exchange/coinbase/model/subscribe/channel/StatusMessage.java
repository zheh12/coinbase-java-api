package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.market.Currency;
import com.exchange.coinbase.model.market.TradingPair;
import com.exchange.coinbase.model.subscribe.Message;
import java.util.List;

public class StatusMessage extends Message {
  private List<TradingPair> products;
  private List<Currency> currencies;

  public List<TradingPair> getProducts() {
    return products;
  }

  public void setProducts(List<TradingPair> products) {
    this.products = products;
  }

  public List<Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }

  @Override
  public String toString() {
    return "StatusMessage{" +
        "products=" + products +
        ", currencies=" + currencies +
        '}';
  }
}
