package com.exchange.coinbase.model.order;

import java.time.Instant;

public class GetAllOrders {
  private String profileId;
  private String productId;
  private SortedBy sortedBy;
  private Sorting sorting;
  private Instant startDate;
  private Instant endDate;
  private Instant before;
  private Instant after;
  private long limit;
  private String status;

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

  public SortedBy getSortedBy() {
    return sortedBy;
  }

  public void setSortedBy(SortedBy sortedBy) {
    this.sortedBy = sortedBy;
  }

  public Sorting getSorting() {
    return sorting;
  }

  public void setSorting(Sorting sorting) {
    this.sorting = sorting;
  }

  public Instant getStartDate() {
    return startDate;
  }

  public void setStartDate(Instant startDate) {
    this.startDate = startDate;
  }

  public Instant getEndDate() {
    return endDate;
  }

  public void setEndDate(Instant endDate) {
    this.endDate = endDate;
  }

  public Instant getBefore() {
    return before;
  }

  public void setBefore(Instant before) {
    this.before = before;
  }

  public Instant getAfter() {
    return after;
  }

  public void setAfter(Instant after) {
    this.after = after;
  }

  public long getLimit() {
    return limit;
  }

  public void setLimit(long limit) {
    this.limit = limit;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "GetAllOrders{" +
        "profileId='" + profileId + '\'' +
        ", productId='" + productId + '\'' +
        ", sortedBy=" + sortedBy +
        ", sorting=" + sorting +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", before=" + before +
        ", after=" + after +
        ", limit=" + limit +
        ", status='" + status + '\'' +
        '}';
  }
}
