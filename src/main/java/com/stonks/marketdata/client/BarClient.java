package com.stonks.marketdata.client;

import com.stonks.marketdata.model.AlpacaBarsResponseWrapper;
import com.stonks.marketdata.model.Bar;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.annotation.Nullable;

@Component
@RequiredArgsConstructor
public class BarClient {

  private final WebClient alpacaDataClient;

  public List<Bar> getBars(
      @NonNull String symbol, @NonNull Instant startDate, @NonNull Instant endDate) {

    val bars =
        alpacaDataClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/v2/stocks/{symbol}/bars")
                        .queryParam("timeframe", "1Min")
                        .queryParam("start", startDate)
                        .queryParam("end", endDate)
                        .build(symbol))
            .retrieve()
            .bodyToMono(AlpacaBarsResponseWrapper.class)
            .block();

    List<Bar> result = new ArrayList<>(bars.getBars());
    if (Objects.nonNull(bars.getNextPageToken())) {
      result.addAll(getBars(symbol, startDate, endDate, bars.getNextPageToken()));
    }

    return result;
  }

  private List<Bar> getBars(
      @NonNull String symbol,
      @NonNull Instant startDate,
      @NonNull Instant endDate,
      @Nullable String nextPageToken) {

    val bars =
        alpacaDataClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/v2/stocks/{symbol}/bars")
                        .queryParam("timeframe", "1Min")
                        .queryParam("start", startDate)
                        .queryParam("end", endDate)
                        .queryParam("page_token", nextPageToken)
                        .build(symbol))
            .retrieve()
            .bodyToMono(AlpacaBarsResponseWrapper.class)
            .block();

    List<Bar> result = new ArrayList<>(bars.getBars());
    if (Objects.nonNull(bars.getNextPageToken())) {
      result.addAll(getBars(symbol, startDate, endDate, bars.getNextPageToken()));
    }

    return result;
  }
}
