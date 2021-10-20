package com.exchange.coinbase.model.subscribe.channel;

import com.exchange.coinbase.model.subscribe.Message;

public abstract class SequenceMessage extends Message {
  private long sequence;

  public long getSequence() {
    return sequence;
  }

  public void setSequence(long sequence) {
    this.sequence = sequence;
  }

  @Override
  public String toString() {
    return "SequenceMessage{" +
        "sequence=" + sequence +
        '}';
  }
}
