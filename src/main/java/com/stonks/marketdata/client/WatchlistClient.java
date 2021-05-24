package com.stonks.marketdata.client;

import com.stonks.marketdata.model.Watchlist;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class WatchlistClient {

  private final WebClient alpacaApiClient;

  private ParameterizedTypeReference<List<Watchlist>> watchlistCollection =
      new ParameterizedTypeReference<>() {};

  public List<Watchlist> getWatchLists() {
    return alpacaApiClient
        .get()
        .uri(uriBuilder -> uriBuilder.path("/v2/watchlists").build())
        .retrieve()
        .bodyToMono(watchlistCollection)
        .block();
  }

  public Watchlist getWatchListsById(String id) {
    return alpacaApiClient
        .get()
        .uri(uriBuilder -> uriBuilder.path("/v2/watchlists/{id}").build(id))
        .retrieve()
        .bodyToMono(Watchlist.class)
        .block();
  }

  public Watchlist createWatchList(Watchlist watchlist) {
    return alpacaApiClient
        .post()
        .uri(uriBuilder -> uriBuilder.path("/v2/watchlists").build())
        .body(BodyInserters.fromValue(watchlist))
        .retrieve()
        .bodyToMono(Watchlist.class)
        .block();
  }

  public void delete(String id) {
    alpacaApiClient
        .delete()
        .uri(uriBuilder -> uriBuilder.path("/v2/watchlists/{id}").build(id))
        .retrieve()
        .bodyToMono(Void.class)
        .block();
  }
}
