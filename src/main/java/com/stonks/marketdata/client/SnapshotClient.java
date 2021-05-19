package com.stonks.marketdata.client;

import com.stonks.marketdata.model.Snapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class SnapshotClient {

  private final WebClient alpacaDataClient;

  public Snapshot getSnapshot(String symbol) {

    return alpacaDataClient
        .get()
        .uri(uriBuilder -> uriBuilder.path("/v2/stocks/{symbol}/snapshot").build(symbol))
        .retrieve()
        .bodyToMono(Snapshot.class)
        .block();
  }
}
