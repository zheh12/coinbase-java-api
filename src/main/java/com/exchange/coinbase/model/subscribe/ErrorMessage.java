package com.exchange.coinbase.model.subscribe;

public class ErrorMessage extends Message {
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ErrorMessage{" +
        "message='" + message + '\'' +
        '}';
  }
}
