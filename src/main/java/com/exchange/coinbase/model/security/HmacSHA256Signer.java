package com.exchange.coinbase.model.security;

import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA256Signer {
  /**
   * Sign the given message using the given secret.
   * @param message message to sign
   * @param secret secret key
   * @return a signed message
   */
  public static String sign(String message, String secret) {
    try {
      Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
      SecretKeySpec secretKeySpec = new SecretKeySpec(
          Base64.getDecoder().decode(secret), "HmacSHA256");
      sha256_HMAC.init(secretKeySpec);
      return Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(message.getBytes()));
    } catch (Exception e) {
      throw new RuntimeException("Unable to sign message.", e);
    }
  }
}
