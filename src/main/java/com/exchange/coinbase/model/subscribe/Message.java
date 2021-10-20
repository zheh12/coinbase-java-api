package com.exchange.coinbase.model.subscribe;

import com.exchange.coinbase.model.subscribe.channel.HeartbeatMessage;
import com.exchange.coinbase.model.subscribe.channel.Level2UpdateMessage;
import com.exchange.coinbase.model.subscribe.channel.SnapshotMessage;
import com.exchange.coinbase.model.subscribe.channel.StatusMessage;
import com.exchange.coinbase.model.subscribe.channel.TickerMessage;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type")
@JsonSubTypes({
    @Type(value = SubscriptionsMessage.class, name = "subscriptions"),
    @Type(value = ErrorMessage.class, name = "error"),
    @Type(value = HeartbeatMessage.class, name="heartbeat"),
    @Type(value = TickerMessage.class, name = "ticker"),
    @Type(value = StatusMessage.class, name = "status"),
    @Type(value = Level2UpdateMessage.class, name = "l2update"),
    @Type(value = SnapshotMessage.class, name = "snapshot")
})
public abstract class Message {
}
