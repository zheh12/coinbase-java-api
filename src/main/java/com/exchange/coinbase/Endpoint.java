package com.exchange.coinbase;

import com.fasterxml.jackson.core.type.TypeReference;
import io.vavr.control.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Endpoint<R> {
  protected String name;
  protected String path;
  protected HttpMethod method;
  protected Option<RateLimit> rateLimit;
  protected Option<RateLimit> burstRateLimit;
  protected Map<String, String> params;
  protected String body="";
  protected TypeReference<R> type;

  public Endpoint(
      String name,String path, HttpMethod method,
      RateLimit rateLimit,
      RateLimit burstRateLimit) {
    this.name = name;
    this.path = path;
    this.method = method;
    this.rateLimit = Option.of(rateLimit);
    this.burstRateLimit = Option.of(burstRateLimit);
    this.params = new HashMap<>();
  }

  public Endpoint(
      String name,String path, HttpMethod method) {
    this(name, path, method, RateLimit.defaultRateLimit(),
        RateLimit.defaultBurstsRateLimit());
  }

  public TypeReference<R> responseType() {
    return this.type;
  }

  public Endpoint<R> withResponseType(TypeReference<R> type) {
    this.type = type;
    return this;
  }

  protected Endpoint<R> copy() {
    Endpoint<R> newEndpoint = new Endpoint<R>(this.name, this.path, this.method, this.rateLimit.getOrNull(),
        this.burstRateLimit.getOrNull()).withResponseType(this.type);
    newEndpoint.params = this.params;
    newEndpoint.body = body;

    return newEndpoint;
  }

  public Endpoint<R> withParams(Map<String, String> params) {
    Endpoint<R> newEndpoint = copy();
    newEndpoint.params = params;
    return newEndpoint;
  }

  public Endpoint<R> withBody(String body) {
    Endpoint<R> newEndpoint = copy();
    newEndpoint.body = body;
    return newEndpoint;
  }

  protected String getBody() {
    return this.body;
  }

  public Request toHttpRequest(String baseUrl,
      String apiKey, String secret, String passphrase) {

    List<String> processedKeys = new ArrayList<>();
    String newPath = path;
    for (String key : params.keySet()) {
      String var = "{" + key + "}";
      if (newPath.contains(var)) {
        newPath = newPath.replace(var, params.get(key));
        processedKeys.add(key);
      }
    }

    processedKeys.forEach(k -> params.remove(k));

    HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.get(baseUrl)
            .resolve(newPath))
        .newBuilder();

    this.params.forEach(urlBuilder::addQueryParameter);

    HttpUrl url = urlBuilder.build();

    RequestBody body = null;

    if (!this.body.isEmpty()) {
      body = RequestBody.create(this.body, MediaType.parse("application/json"));
    }

    return new Request
        .Builder()
        .url(url)
        .method(method.name(), body)
        .build();
  }
}
