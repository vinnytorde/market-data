package com.stonks.marketdata.controller;

import com.stonks.marketdata.exception.DateOutOfBoundsException;
import com.stonks.marketdata.model.Bar;
import com.stonks.marketdata.service.BarService;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BarsController {

  private final BarService barService;

  @GetMapping("/bars/{symbol}")
  public ResponseEntity<List<Bar>> getBars(
      @PathVariable String symbol,
      @RequestParam(value = "start", required = false)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          Instant start,
      @RequestParam(value = "end", required = false)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          Instant end)
      throws DateOutOfBoundsException {

    val earliestDataAvailable = Instant.now().minus(15, ChronoUnit.MINUTES);
    if (Objects.nonNull(start) && start.isAfter(earliestDataAvailable)) {
      throw new DateOutOfBoundsException(
          "start date must be at least 15 minutes after current date");
    }
    if (Objects.nonNull(end) && end.isAfter(earliestDataAvailable)) {
      throw new DateOutOfBoundsException("end date must be at least 15 minutes after current date");
    }

    return ResponseEntity.ok(barService.getBars(symbol, start, end));
  }
}
