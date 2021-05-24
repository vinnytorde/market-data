package com.stonks.marketdata.service;

import com.stonks.marketdata.client.WatchlistClient;
import com.stonks.marketdata.model.Watchlist;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WatchlistService {

  private final WatchlistClient watchlistClient;

  public List<Watchlist> getWatchLists() {
    return watchlistClient.getWatchLists();
  }

  public Watchlist getWatchListById(String id) {
    return watchlistClient.getWatchListsById(id);
  }

  public Watchlist createWatchList(Watchlist watchlist) {
    return watchlistClient.createWatchList(watchlist);
  }

  public void deleteWatchlist(String id) {
    watchlistClient.delete(id);
  }
}
