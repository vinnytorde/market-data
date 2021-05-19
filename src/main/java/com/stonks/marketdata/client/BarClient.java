package com.stonks.marketdata.client;

import com.stonks.marketdata.model.AlpacaBarsResponseWrapper;
import com.stonks.marketdata.model.Bar;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class BarClient {

  private final WebClient barsClient;

  public List<Bar> getBars(final String symbol, Instant startDate) {
    val bars =
        barsClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/v2/stocks/{symbol}/bars")
                        .queryParam("timeframe", "1Min")
                        .queryParam("start", startDate)
                        .build(symbol))
            .retrieve()
            .bodyToMono(AlpacaBarsResponseWrapper.class)
            .block();
    return bars.getBars();
  }
}
