package com.stonks.marketdata.controller;

import com.stonks.marketdata.model.Bar;
import com.stonks.marketdata.service.BarService;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BarsController {

  private final BarService barService;

  @GetMapping("/bars/{symbol}")
  public List<Bar> getBars(
      @PathVariable String symbol,
      @RequestParam(value = "start", required = false)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          Instant start,
      @RequestParam(value = "end", required = false)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          Instant end) {
    return barService.getBars(symbol, start, end);
  }
}
