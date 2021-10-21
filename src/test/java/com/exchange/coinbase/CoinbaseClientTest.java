package com.exchange.coinbase;

import com.exchange.coinbase.model.market.Candle;
import com.exchange.coinbase.model.market.CandleInterval;
import com.exchange.coinbase.model.market.OrderSide;
import com.exchange.coinbase.model.market.Orderbook;
import com.exchange.coinbase.model.market.OrderbookLevel;
import com.exchange.coinbase.model.market.TradingPair;
import com.exchange.coinbase.model.order.NewOrder;
import com.exchange.coinbase.model.order.OrderStatus;
import com.exchange.coinbase.model.order.OrderType;
import com.exchange.coinbase.model.order.TimeInForce;
import com.exchange.coinbase.model.profiles.Profile;
import com.exchange.coinbase.model.subscribe.channel.FullRequest;
import com.exchange.coinbase.model.subscribe.channel.HeartbeatRequest;
import com.exchange.coinbase.model.subscribe.channel.Level2Request;
import com.exchange.coinbase.model.subscribe.channel.StatusRequest;
import com.exchange.coinbase.model.subscribe.channel.TickerRequest;
import com.exchange.coinbase.model.user.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.vavr.control.Option;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoinbaseClientTest {

  public static final String apiKey = "d865753676c218e166571a3caf2f2fc4";
  public static final String passphrase = "am1hz5cotnl";
  public static final String secret = "HfHzkjqTYU7qVlfT4VbMjxIycPahIL7iKpOo0J0iJzSbA1cPobOkkw2WQ4KK0/hSFUaiTiQBmzfeW/XzGwCVww==";

  public static String baseUrl = "https://api-public.sandbox.exchange.coinbase.com";
  public static String wsBaseUrl = "wss://ws-feed-public.sandbox.exchange.coinbase.com";

  public static Logger logger = LoggerFactory.getLogger(CoinbaseClientTest.class);

  public static void main(String[] args) throws JsonProcessingException, InterruptedException {
    CoinbaseClient client = new CoinbaseClient()
        .baseUrl(baseUrl)
        .wsBaseUrl(wsBaseUrl)
        .apiKey(apiKey)
        .secret(secret)
        .passphrase(passphrase);

    List<Account> accounts = client.getAllAccounts().block();

    logger.info("get all accounts {}", accounts);

    List<Profile> profiles = client.getProfiles().block();

    logger.info("get all profiles {}", profiles);

    List<TradingPair> products = client
        .getProducts()
        .block();

    logger.info("all trading paris is " + products);

    Orderbook orderbook =
        client.getOrderBook("BTC-USD", OrderbookLevel.FULL_AGG_ORDER_BOOK)
            .block();

    logger.info("orderbook for btcusd is " + orderbook);

    List<Candle> candles = client.getCandles("BTC-USD",
        CandleInterval.INTERVAL_1M,
            Option.of(Instant.now().minusSeconds(12000)), Option.none())
        .block();

    logger.info("candles for btcusd is " + candles);

    // create new order
    NewOrder order = new NewOrder();
    order.setType(OrderType.LIMIT);
    order.setProductId("BTC-USD");
    order.setPrice(new BigDecimal("70000.0"));
    order.setSide(OrderSide.SELL);
    order.setClientOid(UUID.randomUUID().toString());
    order.setSize(new BigDecimal("0.01"));
    order.setTimeInForce(TimeInForce.GTC);
    OrderStatus status = client.newOrder(order).block();

    logger.info("create new order {} status {}", order, status);

    // query order
    List<OrderStatus> orders = client
        .getAllOrders(null, null, null,
            null, null).block();

    logger.info("get all orders {}", orders);

    OrderStatus status1 = client.queryOrderById(status.getId()).block();
    OrderStatus status2 = client.queryOrderByOid(order.getClientOid()).block();

    logger.info("query for order status {}, {}", status1, status2);

    WebSocketConnection connection = client.newWebSocket();

    connection.getData()
        .subscribe(x -> logger.info("receive from web socket message: {}", x),
            Throwable::printStackTrace);

    connection.addRequests(new FullRequest("BTC-USD"));

    connection.addRequests(
        new HeartbeatRequest("BTC-USD"),
        new StatusRequest());

    // wait some time, add other heartbeat request
    Thread.sleep(1000 * 10);
    logger.info("add new channel for web socket");
    connection.addRequests(
        new HeartbeatRequest("ETH-USD"),
        new Level2Request("ETH-USD", "BTC-USD"),
        new TickerRequest("ETH-USD", "BTC-USD")
    );
  }
}
