package com.exchange.coinbase.model.subscribe.channel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "name")
@JsonSubTypes({
    @Type(value = Level2Request.class, name = "level2"),
    @Type(value = HeartbeatRequest.class, name = "heartbeat"),
    @Type(value = StatusRequest.class, name = "status"),
    @Type(value = TickerRequest.class, name = "ticker"),
    @Type(value = FullRequest.class, name = "full")
})
public abstract class ChannelRequest {
}
