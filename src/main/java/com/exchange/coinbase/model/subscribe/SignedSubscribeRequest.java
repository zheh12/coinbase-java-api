package com.exchange.coinbase.model.subscribe;

import com.exchange.coinbase.model.subscribe.channel.ChannelRequest;
import java.util.List;

public class SignedSubscribeRequest extends SubscribeRequest {
  private String signature;
  private String key;
  private String passphrase;
  private String timestamp;

  public SignedSubscribeRequest(
      List<ChannelRequest> channels,
      String key, String passphrase) {
    super(channels);
    this.key = key;
    this.passphrase = passphrase;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getPassphrase() {
    return passphrase;
  }

  public void setPassphrase(String passphrase) {
    this.passphrase = passphrase;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
