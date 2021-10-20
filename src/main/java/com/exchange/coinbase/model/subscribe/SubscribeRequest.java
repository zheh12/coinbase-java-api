package com.exchange.coinbase.model.subscribe;

import com.exchange.coinbase.model.subscribe.channel.ChannelRequest;
import java.util.List;

public class SubscribeRequest {
  private String type = "subscribe";
  private List<ChannelRequest> channels;

  public SubscribeRequest(
      List<ChannelRequest> channels) {
    this.channels = channels;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<ChannelRequest> getChannels() {
    return channels;
  }

  public void setChannels(
      List<ChannelRequest> channels) {
    this.channels = channels;
  }
}
