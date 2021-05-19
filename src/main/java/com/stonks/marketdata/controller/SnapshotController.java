package com.stonks.marketdata.controller;

import com.stonks.marketdata.model.Snapshot;
import com.stonks.marketdata.service.SnapshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SnapshotController {

  private final SnapshotService snapshotService;

  @GetMapping("/snapshots/{symbol}")
  public Snapshot getSnapshot(@PathVariable String symbol) {
    return snapshotService.getSnapshot(symbol);
  }
}
