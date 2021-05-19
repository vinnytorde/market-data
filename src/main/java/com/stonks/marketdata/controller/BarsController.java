package com.stonks.marketdata.controller;

import com.stonks.marketdata.model.Bar;
import com.stonks.marketdata.service.BarService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BarsController {

  private final BarService barService;

  @GetMapping("/bars/{symbol}")
  public List<Bar> getBars(@PathVariable String symbol) {
    return barService.getBars(symbol);
  }
}
