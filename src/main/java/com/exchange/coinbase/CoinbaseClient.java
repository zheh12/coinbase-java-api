package com.exchange.coinbase;

import com.exchange.coinbase.error.CoinbaseApiException;
import com.exchange.coinbase.model.market.Candle;
import com.exchange.coinbase.model.market.CandleInterval;
import com.exchange.coinbase.model.market.Orderbook;
import com.exchange.coinbase.model.market.OrderbookLevel;
import com.exchange.coinbase.model.market.TradingPair;
import com.exchange.coinbase.model.order.NewOrder;
import com.exchange.coinbase.model.order.OrderStatus;
import com.exchange.coinbase.model.order.SortedBy;
import com.exchange.coinbase.model.order.Sorting;
import com.exchange.coinbase.model.order.Status;
import com.exchange.coinbase.model.profiles.Profile;
import com.exchange.coinbase.model.user.Account;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.vavr.control.Option;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class CoinbaseClient {

  public static final Logger logger = LoggerFactory.getLogger(CoinbaseClient.class);

  private final OkHttpClient client;
  private final ObjectMapper mapper;
  private String secret;
  private String apiKey;
  private String passphrase;
  private String baseUrl = "https://api.exchange.coinbase.com";
  private String wsBaseUrl = "wss://ws-feed.exchange.coinbase.com";

  public CoinbaseClient(OkHttpClient client) {
    this.mapper = new ObjectMapper();
    this.mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);
    this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    this.mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    this.mapper.registerModule(new JavaTimeModule());
    this.client = client;
  }

  public CoinbaseClient() {
    this(new OkHttpClient.Builder().build());
  }

  public synchronized CoinbaseClient baseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
    return this;
  }

  public synchronized CoinbaseClient wsBaseUrl(String wsBaseUrl) {
    this.wsBaseUrl = wsBaseUrl;
    return this;
  }

  public synchronized CoinbaseClient passphrase(String passphrase) {
    this.passphrase = passphrase;
    return this;
  }

  public synchronized CoinbaseClient secret(String secret) {
    this.secret = secret;
    return this;
  }

  public synchronized CoinbaseClient apiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

  public final static Endpoint<List<Account>> accountsEndpoint = new SignedEndpoint<List<Account>>("accounts",
      "/accounts", HttpMethod.GET,
      RateLimit.seconds(25), RateLimit.seconds(50))
      .withResponseType(new TypeReference<List<Account>>() {});

  public final static Endpoint<List<Profile>> profilesEndpoint = new SignedEndpoint<List<Profile>>("profiles",
      "/profiles", HttpMethod.GET)
      .withResponseType(new TypeReference<List<Profile>>() {});

  public final static Endpoint<OrderStatus> newOrderEndpoint = new SignedEndpoint<OrderStatus>("newOrder",
      "/orders", HttpMethod.POST)
      .withResponseType(new TypeReference<OrderStatus>() {});

  public final static Endpoint<String> cancelOrderEndpoint = new SignedEndpoint<String>("cancelOrder",
      "/orders/{order_id}", HttpMethod.DELETE)
      .withResponseType(new TypeReference<String>() {});

  public final static Endpoint<OrderStatus> queryOrderEndpoint = new SignedEndpoint<OrderStatus>("queryOrder",
      "/orders/{order_id}", HttpMethod.GET)
      .withResponseType(new TypeReference<OrderStatus>() {});

  public final static Endpoint<List<String>> cancelAllOrdersEndpoint = new SignedEndpoint<List<String>>("cancelOrder",
      "/orders", HttpMethod.DELETE)
      .withResponseType(new TypeReference<List<String>>() {});

  public final static Endpoint<List<OrderStatus>> queryOrdersEndpoint = new SignedEndpoint<List<OrderStatus>>("queryOrders",
      "/orders", HttpMethod.GET)
      .withResponseType(new TypeReference<List<OrderStatus>>() {});

  public final static Endpoint<List<TradingPair>> productsEndpoint = new Endpoint<List<TradingPair>>("products",
      "/products", HttpMethod.GET)
      .withResponseType(new TypeReference<List<TradingPair>>() {});

  public final static Endpoint<Orderbook> orderBookEndpoint = new Endpoint<Orderbook>("orderbook",
      "/products/{product_id}/book", HttpMethod.GET)
      .withResponseType(new TypeReference<Orderbook>() {});

  public final static Endpoint<List<Candle>> candlesEndpoint = new Endpoint<List<Candle>>("candles",
      "/products/{product_id}/candles", HttpMethod.GET)
      .withResponseType(new TypeReference<List<Candle>>() {});

  public Mono<List<Account>> getAllAccounts() {
    return send(accountsEndpoint);
  }

  public Mono<List<Profile>> getProfiles() {
    return send(profilesEndpoint);
  }

  public Mono<OrderStatus> newOrder(NewOrder order) {
    return send(newOrderEndpoint, order);
  }

  public Mono<String> cancelOrderById(String orderId) {
    Map<String, String> params = new HashMap<>();
    params.put("order_id", orderId);
    return send(cancelOrderEndpoint.withParams(params));
  }

  public Mono<String> cancelOrderByOid(String oid) {
    Map<String, String> params = new HashMap<>();
    params.put("order_id", "client:" + oid);
    return send(cancelOrderEndpoint.withParams(params));
  }

  public Mono<OrderStatus> queryOrderById(String orderId) {
    Map<String, String> params = new HashMap<>();
    params.put("order_id", orderId);
    return send(queryOrderEndpoint.withParams(params));
  }

  public Mono<OrderStatus> queryOrderByOid(String oid) {
    Map<String, String> params = new HashMap<>();
    params.put("order_id", "client:" + oid);
    return send(queryOrderEndpoint.withParams(params));
  }

  public Mono<List<String>> cancelAllOrders(String productId) {
    Map<String, String> params = new HashMap<>();
    if (productId != null) {
      params.put("product_id", productId);
    }

    return send(cancelAllOrdersEndpoint.withParams(params));
  }

  public Mono<List<OrderStatus>> getAllOrders(String productId,
      Long limit, Status status,
      SortedBy sortedBy, Sorting sorting) {

    Map<String, String> params = new HashMap<>();
    if (productId != null) {
      params.put("product_id", productId);
    }

    if (sortedBy != null) {
      params.put("sortedBy", sortedBy.name().toLowerCase(Locale.ROOT));
    }

    if (sorting != null) {
      params.put("sorting", sorting.name().toLowerCase(Locale.ROOT));
    }

    if (status != null) {
      params.put("status", status.name().toLowerCase(Locale.ROOT));
    }

    if (limit != null) {
      params.put("limit", String.valueOf(limit));
    }

    return send(queryOrdersEndpoint.withParams(params));
  }

  /**
   * Gets a list of available currency pairs for trading
   * @return
   */
  public Mono<List<TradingPair>> getProducts() {
    return send(productsEndpoint);
  }

  /**
   * get the orderbook
   */
  public Mono<Orderbook> getOrderBook(String productId, OrderbookLevel level) {
    Map<String, String> params = new HashMap<>();
    params.put("product_id", productId);
    params.put("level", String.valueOf(level.level()));
    return send(orderBookEndpoint.withParams(params));
  }

  public Mono<List<Candle>> getCandles(String productId, CandleInterval interval,
      Option<Instant> start, Option<Instant> end) {
    Map<String, String> params = new HashMap<>();
    params.put("product_id", productId);
    params.put("granularity", String.valueOf(interval.getTime()));
    start.forEach(x -> params.put("start", x.toString()));
    end.forEach(x -> params.put("end", x.toString()));

    return send(candlesEndpoint.withParams(params));
  }

  public WebSocketConnection newWebSocket() {
    Request request = new Request.Builder().url(wsBaseUrl).build();

    return new WebSocketConnection(client, mapper, request, apiKey,
        secret, passphrase);
  }

  private <T, R> Mono<R> send(Endpoint<R> endpoint, T body) {
    try {
      return send(endpoint.withBody(mapper.writeValueAsString(body)));
    } catch (JsonProcessingException e) {
      return Mono.error(e);
    }
  }

  private <R> Mono<R> send(Endpoint<R> endpoint) {
    Request request = endpoint.toHttpRequest(baseUrl, apiKey, secret, passphrase);

    return Mono.create(sink -> client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {
        logger.error("coinbase send request {} error", call.request(), e);
        sink.error(CoinbaseApiException.networkErrorException(e));
      }

      @Override
      public void onResponse(@NotNull Call call, @NotNull Response response) {
        logger.info("coinbase send request {} response message {}:{}", call.request(),
            response.code(), response.message());

        // success response
        if (response.isSuccessful()) {
          try {

            if (response.body() == null) {
              throw new IOException("response body is null");
            }

            String content = Objects.requireNonNull(response.body()).string();
            R resp = mapper.readValue(content, endpoint.responseType());
            sink.success(resp);
          } catch (JacksonException e) {
            sink.error(CoinbaseApiException.jsonParseException(e));
          } catch (IOException e) {
            sink.error(CoinbaseApiException.networkErrorException(e));
          }
        } else {
          try {
            String message = null;
            if (response.body() != null) {
              message = response.body().string();
            }

            sink.error(CoinbaseApiException.errorCodeException(response.code(), message));
          } catch (IOException e) {
            sink.error(CoinbaseApiException.networkErrorException(e));
          }
        }
      }
    }));
  }
}
