package com.stonks.marketdata.service;

import com.stonks.marketdata.client.SnapshotClient;
import com.stonks.marketdata.model.Snapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SnapshotService {

  private final SnapshotClient snapshotClient;

  public Snapshot getSnapshot(String symbol) {
    return snapshotClient.getSnapshot(symbol);
  }
}
