package com.stonks.marketdata.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlpacaBarsResponseWrapper {
  private List<Bar> bars;
}
