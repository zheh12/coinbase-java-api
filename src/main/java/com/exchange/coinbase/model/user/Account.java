package com.exchange.coinbase.model.user;

import java.math.BigDecimal;

/**
 * Information for a single account. Use this
 * endpoint when you know the account_id.
 */
public class Account {
  private String id;
  private String currency;
  private BigDecimal balance;
  private BigDecimal available;
  private BigDecimal hold;
  private String profileId;
  private boolean tradingEnabled;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getAvailable() {
    return available;
  }

  public void setAvailable(BigDecimal available) {
    this.available = available;
  }

  public BigDecimal getHold() {
    return hold;
  }

  public void setHold(BigDecimal hold) {
    this.hold = hold;
  }

  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public boolean isTradingEnabled() {
    return tradingEnabled;
  }

  public void setTradingEnabled(boolean tradingEnabled) {
    this.tradingEnabled = tradingEnabled;
  }

  @Override
  public String toString() {
    return "Account{" +
        "id='" + id + '\'' +
        ", currency='" + currency + '\'' +
        ", balance=" + balance +
        ", available=" + available +
        ", hold=" + hold +
        ", profileId='" + profileId + '\'' +
        ", tradingEnabled=" + tradingEnabled +
        '}';
  }
}
