package com.exchange.coinbase.model.subscribe;

import com.exchange.coinbase.model.subscribe.channel.ChannelRequest;
import java.util.List;

public class SubscriptionsMessage extends Message {
  private List<ChannelRequest> channels;

  public List<ChannelRequest> getChannels() {
    return channels;
  }

  public void setChannels(
      List<ChannelRequest> channels) {
    this.channels = channels;
  }

  @Override
  public String toString() {
    return "SubscriptionsMessage{" +
        "channels=" + channels +
        '}';
  }
}
