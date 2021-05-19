package com.stonks.marketdata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Value("${alpaca.endpoint.data}")
  private String alpacaDataBaseUrl;

  @Value("${alpaca.key}")
  private String alpacaKeyId;

  @Value("${alpaca.secret}")
  private String alpacaSecretKey;

  @Bean
  public WebClient barsClient() {
    return WebClient.builder()
        .defaultHeader("APCA-API-KEY-ID", alpacaKeyId)
        .defaultHeader("APCA-API-SECRET-KEY", alpacaSecretKey)
        .baseUrl(alpacaDataBaseUrl)
        .build();
  }
}
