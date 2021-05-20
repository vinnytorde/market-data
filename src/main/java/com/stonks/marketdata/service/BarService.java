package com.stonks.marketdata.service;

import com.stonks.marketdata.client.BarClient;
import com.stonks.marketdata.model.Bar;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarService {

  private final BarClient barClient;

  public List<Bar> getBars(final String symbol, final Instant startDate, final Instant endDate) {
    var start = startDate;
    if (Objects.isNull(start)) {
      start = Instant.now().minus(1, ChronoUnit.DAYS);
    }

    var end = endDate;
    if (Objects.isNull(endDate)) {
      end = Instant.now().minus(15, ChronoUnit.MINUTES);
    }

    return barClient.getBars(symbol, start, end);
  }
}
