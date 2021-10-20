package com.exchange.coinbase;

import com.exchange.coinbase.model.security.HmacSHA256Signer;
import java.time.Instant;

import okhttp3.Request;

public class SignedEndpoint<R> extends Endpoint<R> {

  public SignedEndpoint(String name, String path, HttpMethod method,
      RateLimit rateLimit, RateLimit burstRateLimit) {
    super(name, path, method, rateLimit, burstRateLimit);
  }

  public SignedEndpoint(String name, String path, HttpMethod method) {
    super(name, path, method);
  }

  private Request signedRequest(
      String key,
      String secret,
      String passphrase,
      Request request) {

    String timestamp = String.valueOf(Instant.now().toEpochMilli() / 1000);
    String message =
        timestamp + method.name() + request.url().encodedPath() +
            this.getBody();
    String signedMessage = HmacSHA256Signer.sign(message, secret);

    return request.newBuilder()
        .header("CB-ACCESS-KEY", key)
        .header("CB-ACCESS-SIGN", signedMessage)
        .header("CB-ACCESS-TIMESTAMP", timestamp)
        .header("CB-ACCESS-PASSPHRASE", passphrase)
        .build();
  }

  @Override
  public Endpoint<R> copy() {
    Endpoint<R> newEndpoint = new SignedEndpoint<R>(this.name, this.path, this.method, this.rateLimit.getOrNull(),
        this.burstRateLimit.getOrNull()).withResponseType(this.type);
    newEndpoint.params = this.params;
    newEndpoint.body = body;

    return newEndpoint;
  }

  @Override
  public Request toHttpRequest(String baseUrl, String key,
      String secret, String passphrase) {
    Request request = super.toHttpRequest(baseUrl, key, secret, passphrase);
    return signedRequest(key, secret, passphrase, request);
  }
}
