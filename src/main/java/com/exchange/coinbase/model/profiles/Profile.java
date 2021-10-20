package com.exchange.coinbase.model.profiles;

import java.time.Instant;

public class Profile {
  private String id;
  private String userId;
  private String name;
  private boolean active;
  private boolean isDefault;
  private Instant createdAt;
  private boolean hasMargin;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public void setDefault(boolean aDefault) {
    isDefault = aDefault;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public boolean isHasMargin() {
    return hasMargin;
  }

  public void setHasMargin(boolean hasMargin) {
    this.hasMargin = hasMargin;
  }

  @Override
  public String toString() {
    return "Profile{" +
        "id='" + id + '\'' +
        ", userId='" + userId + '\'' +
        ", name='" + name + '\'' +
        ", active=" + active +
        ", isDefault=" + isDefault +
        ", createdAt=" + createdAt +
        ", hasMargin=" + hasMargin +
        '}';
  }
}
