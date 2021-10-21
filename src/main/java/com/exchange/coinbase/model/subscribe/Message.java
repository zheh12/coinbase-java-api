package com.exchange.coinbase.model.subscribe;

import com.exchange.coinbase.model.subscribe.channel.ActivateMessage;
import com.exchange.coinbase.model.subscribe.channel.ChangeMessage;
import com.exchange.coinbase.model.subscribe.channel.DoneMessage;
import com.exchange.coinbase.model.subscribe.channel.HeartbeatMessage;
import com.exchange.coinbase.model.subscribe.channel.Level2UpdateMessage;
import com.exchange.coinbase.model.subscribe.channel.MatchMessage;
import com.exchange.coinbase.model.subscribe.channel.OpenMessage;
import com.exchange.coinbase.model.subscribe.channel.ReceivedMessage;
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
    @Type(value = SnapshotMessage.class, name = "snapshot"),
    @Type(value = ReceivedMessage.class, name = "received"),
    @Type(value = OpenMessage.class, name = "open"),
    @Type(value = DoneMessage.class, name = "done"),
    @Type(value = MatchMessage.class, name = "match"),
    @Type(value = ChangeMessage.class, name = "change"),
    @Type(value = ActivateMessage.class, name = "activate")
})
public abstract class Message {
}
