package com.exchange.coinbase.error;

import com.fasterxml.jackson.core.JacksonException;
import java.io.IOException;

/**
 * coinbase api exception
 */
public class CoinbaseApiException extends RuntimeException {

  public CoinbaseApiException(IOException exception) {
    super(exception);
  }

  public CoinbaseApiException(String message) {
    super(message);
  }

  public static class JsonParseException extends CoinbaseApiException {

    public JsonParseException(JacksonException exception) {
      super(exception);
    }
  }

  public static class ErrorCodeException extends CoinbaseApiException {
    private int code;
    private String message;

    public ErrorCodeException(int code, String message) {
      super(String.format("error:  %d, %s", code, message));
    }
  }

  public static class NetworkErrorException extends CoinbaseApiException {
    public NetworkErrorException(IOException exception) {
      super(exception);
    }
  }

  public static NetworkErrorException networkErrorException(IOException exception) {
    return new NetworkErrorException(exception);
  }

  public static ErrorCodeException errorCodeException(int code, String message) {
    return new ErrorCodeException(code, message);
  }

  public static JsonParseException jsonParseException(JacksonException exception) {
    return new JsonParseException(exception);
  }
}
