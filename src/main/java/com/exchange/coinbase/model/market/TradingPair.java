package com.exchange.coinbase.model.market;

import java.math.BigDecimal;

/**
 * Trading pair in coinbase
 * The base_min_size and base_max_size fields define
 * the min and max order size.
 *
 * The min_market_funds and max_market_funds fields
 * define the min and max funds allowed in a market order
 *
 * status_message provides any extra information regarding
 * this status if available.
 *
 * The quote_increment field specifies the min order price
 * as well as the price increment.
 *
 * The order price must be a multiple of this increment.
 *
 * The base_increment field specifies the minimum increment
 * for the base_currency.
 *
 * trading_disabled indicates whether trading is currently
 * restricted on this product, this includes whether both
 * new orders and order cancelations are restricted.
 *
 * cancel_only indicates whether this product only accepts
 * cancel requests for orders.
 *
 * post_only indicates whether only marker orders can be placed.
 * No orders will be matched when post_only mode is active.
 *
 * limit_only indicates whether this product only accepts limit orders.
 *
 * Only a maximum of one of trading_disabled, cancel_only, post_only, limit_only can be true at once. If none are true, the product is trading normally.
 *
 * auction_mode boolean which indicates whether or not the book is in auction mode. For more details on the auction mode see the documentation section describing the level 1 book which contains information pertaining to products in auction mode.
 */
public class TradingPair {
  private String id;
  private String baseCurrency;
  private String quoteCurrency;
  private BigDecimal baseMinSize;
  private BigDecimal baseMaxSize;
  private BigDecimal quoteIncrement;
  private BigDecimal baseIncrement;
  private String displayName;
  private BigDecimal minMarketFunds;
  private BigDecimal maxMarketFunds;
  private boolean marginEnabled;
  private boolean postOnly;
  private boolean limitOnly;
  private boolean cancelOnly;
  private String status;
  private String statusMessage;
  private boolean auctionMode;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBaseCurrency() {
    return baseCurrency;
  }

  public void setBaseCurrency(String baseCurrency) {
    this.baseCurrency = baseCurrency;
  }

  public String getQuoteCurrency() {
    return quoteCurrency;
  }

  public void setQuoteCurrency(String quoteCurrency) {
    this.quoteCurrency = quoteCurrency;
  }

  public BigDecimal getBaseMinSize() {
    return baseMinSize;
  }

  public void setBaseMinSize(BigDecimal baseMinSize) {
    this.baseMinSize = baseMinSize;
  }

  public BigDecimal getBaseMaxSize() {
    return baseMaxSize;
  }

  public void setBaseMaxSize(BigDecimal baseMaxSize) {
    this.baseMaxSize = baseMaxSize;
  }

  public BigDecimal getQuoteIncrement() {
    return quoteIncrement;
  }

  public void setQuoteIncrement(BigDecimal quoteIncrement) {
    this.quoteIncrement = quoteIncrement;
  }

  public BigDecimal getBaseIncrement() {
    return baseIncrement;
  }

  public void setBaseIncrement(BigDecimal baseIncrement) {
    this.baseIncrement = baseIncrement;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public BigDecimal getMinMarketFunds() {
    return minMarketFunds;
  }

  public void setMinMarketFunds(BigDecimal minMarketFunds) {
    this.minMarketFunds = minMarketFunds;
  }

  public BigDecimal getMaxMarketFunds() {
    return maxMarketFunds;
  }

  public void setMaxMarketFunds(BigDecimal maxMarketFunds) {
    this.maxMarketFunds = maxMarketFunds;
  }

  public boolean isMarginEnabled() {
    return marginEnabled;
  }

  public void setMarginEnabled(boolean marginEnabled) {
    this.marginEnabled = marginEnabled;
  }

  public boolean isPostOnly() {
    return postOnly;
  }

  public void setPostOnly(boolean postOnly) {
    this.postOnly = postOnly;
  }

  public boolean isLimitOnly() {
    return limitOnly;
  }

  public void setLimitOnly(boolean limitOnly) {
    this.limitOnly = limitOnly;
  }

  public boolean isCancelOnly() {
    return cancelOnly;
  }

  public void setCancelOnly(boolean cancelOnly) {
    this.cancelOnly = cancelOnly;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  public boolean isAuctionMode() {
    return auctionMode;
  }

  public void setAuctionMode(boolean auctionMode) {
    this.auctionMode = auctionMode;
  }

  @Override
  public String toString() {
    return "TradingPair{" +
        "id='" + id + '\'' +
        ", baseCurrency='" + baseCurrency + '\'' +
        ", quoteCurrency='" + quoteCurrency + '\'' +
        ", baseMinSize=" + baseMinSize +
        ", baseMaxSize=" + baseMaxSize +
        ", quoteIncrement=" + quoteIncrement +
        ", baseIncrement=" + baseIncrement +
        ", displayName='" + displayName + '\'' +
        ", minMarketFunds=" + minMarketFunds +
        ", maxMarketFunds=" + maxMarketFunds +
        ", marginEnabled=" + marginEnabled +
        ", postOnly=" + postOnly +
        ", limitOnly=" + limitOnly +
        ", cancelOnly=" + cancelOnly +
        ", status=" + status +
        ", statusMessage='" + statusMessage + '\'' +
        ", auctionMode=" + auctionMode +
        '}';
  }
}
