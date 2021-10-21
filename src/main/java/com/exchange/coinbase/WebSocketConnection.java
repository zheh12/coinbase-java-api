package com.exchange.coinbase;

import com.exchange.coinbase.model.security.HmacSHA256Signer;
import com.exchange.coinbase.model.subscribe.Message;
import com.exchange.coinbase.model.subscribe.SignedSubscribeRequest;
import com.exchange.coinbase.model.subscribe.SubscribeRequest;
import com.exchange.coinbase.model.subscribe.channel.ChannelRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

/**
 * A web socket connection can
 * add new channel to listen.
 */
public class WebSocketConnection {

  public static final Logger logger = LoggerFactory.getLogger(WebSocketConnection.class);

  private WebSocket webSocket;
  private Request request;
  private OkHttpClient client;
  private Flux<Message> flux;
  private ObjectMapper mapper;
  private List<ChannelRequest> requests = new ArrayList<>();
  private String apiKey;
  private String secret;
  private String passphrase;

  public WebSocketConnection(OkHttpClient client,
      ObjectMapper mapper,
      Request request,
      String apiKey,
      String secret,
      String passphrase) {
    this.request = request;
    this.mapper = mapper;
    this.client = client;
    this.apiKey = apiKey;
    this.secret = secret;
    this.passphrase = passphrase;
    init(request);
  }

  private void init(Request request) {
    flux = Flux.<Message>create(sink -> {
      logger.info("start a new websocket for {}", request);
      webSocket = client.newWebSocket(request, new WebSocketListener() {
        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
          super.onMessage(webSocket, text);
          try {
            Message message = mapper.readValue(text, Message.class);
            sink.next(message);
          } catch (JsonProcessingException e) {
            logger.error("ignore parse message {} error", text, e);
          }
        }

        @Override
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t,
            @Nullable Response response) {
          logger.error("websocket failure", t);
          super.onFailure(webSocket, t, response);
          sink.error(t);
        }
      });

      try {
        sendChannelRequest(this.requests);
      } catch (JsonProcessingException e) {
        sink.error(e);
      }
    }).doFinally(t -> {
      if (webSocket != null) {
        webSocket.cancel();
      }
    }).timeout(Duration.ofSeconds(60))
        .retryWhen(Retry.backoff(Integer.MAX_VALUE, Duration.ofSeconds(60)));
  }

  public Flux<Message> getData() {
    return flux;
  }

  public boolean addRequests(ChannelRequest... channelRequests)
      throws JsonProcessingException {
    return addRequests(Arrays.asList(channelRequests));
  }

  public boolean addRequests(List<ChannelRequest> channelRequests)
      throws JsonProcessingException {
    this.requests.addAll(channelRequests);
    return sendChannelRequest(channelRequests);
  }

  private boolean sendChannelRequest(List<ChannelRequest> channelRequests)
      throws JsonProcessingException {
    SubscribeRequest request = new SubscribeRequest(channelRequests);
    if (this.apiKey != null && this.secret != null && this.passphrase != null) {
      SignedSubscribeRequest signedSubscribeRequest = new SignedSubscribeRequest(channelRequests, apiKey, passphrase);
      String timestamp = String.valueOf(Instant.now().toEpochMilli() / 1000);
      signedSubscribeRequest.setTimestamp(timestamp);
      signedSubscribeRequest.setKey(apiKey);
      signedSubscribeRequest.setPassphrase(passphrase);
      String path = "/users/self/verify";
      String message =
          timestamp + HttpMethod.GET.name() + path;
      String signedMessage = HmacSHA256Signer.sign(message, secret);
      signedSubscribeRequest.setSignature(signedMessage);
      request = signedSubscribeRequest;
    }

    String sendMessage = mapper.writeValueAsString(request);
    return this.webSocket.send(sendMessage);
  }
}
