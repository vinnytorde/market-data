package com.stonks.marketdata.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Snapshot {
  private String symbol;
  private Trade latestTrade;
  private Quote latestQuote;
  private Bar minuteBar;
  private Bar dailyBar;
  private Bar previousDailyBar;
}
