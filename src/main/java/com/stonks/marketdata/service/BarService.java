package com.stonks.marketdata.service;

import com.stonks.marketdata.client.BarClient;
import com.stonks.marketdata.model.Bar;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarService {

  private final BarClient barClient;

  public List<Bar> getBars(final String symbol) {
    val yesterday = Instant.now().minus(1, ChronoUnit.DAYS);
    return barClient.getBars(symbol, yesterday);
  }
}
