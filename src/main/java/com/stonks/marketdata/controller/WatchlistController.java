package com.stonks.marketdata.controller;

import com.stonks.marketdata.model.Watchlist;
import com.stonks.marketdata.service.WatchlistService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WatchlistController {

  private final WatchlistService watchlistService;

  @GetMapping("/watchlists")
  public List<Watchlist> getWatchLists() {
    return watchlistService.getWatchLists();
  }

  @PostMapping("/watchlists")
  public Watchlist createWatchList(@RequestBody Watchlist watchlist) {
    return watchlistService.createWatchList(watchlist);
  }

  @GetMapping("/watchlists/{id}")
  public Watchlist getWatchListById(@PathVariable String id) {
    return watchlistService.getWatchListById(id);
  }

  @DeleteMapping("/watchlists/{id}")
  public void deleteWatchList(@PathVariable String id) {
    watchlistService.deleteWatchlist(id);
  }
}
