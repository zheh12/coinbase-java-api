package com.exchange.coinbase.model.market;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Currency {
  private String id;
  private String name;
  private BigDecimal minSize;
  private String status;
  private String statusMessage;
  private BigDecimal maxPrecision;
  private List<String> convertibleTo;
  private Map<String, Object> details;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getMinSize() {
    return minSize;
  }

  public void setMinSize(BigDecimal minSize) {
    this.minSize = minSize;
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

  public BigDecimal getMaxPrecision() {
    return maxPrecision;
  }

  public void setMaxPrecision(BigDecimal maxPrecision) {
    this.maxPrecision = maxPrecision;
  }

  public List<String> getConvertibleTo() {
    return convertibleTo;
  }

  public void setConvertibleTo(List<String> convertibleTo) {
    this.convertibleTo = convertibleTo;
  }

  public Map<String, Object> getDetails() {
    return details;
  }

  public void setDetails(Map<String, Object> details) {
    this.details = details;
  }

  @Override
  public String toString() {
    return "Currency{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", minSize=" + minSize +
        ", status='" + status + '\'' +
        ", statusMessage='" + statusMessage + '\'' +
        ", maxPrecision=" + maxPrecision +
        ", convertibleTo=" + convertibleTo +
        ", details=" + details +
        '}';
  }
}
