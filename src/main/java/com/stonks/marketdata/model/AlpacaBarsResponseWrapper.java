package com.stonks.marketdata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlpacaBarsResponseWrapper {
  private List<Bar> bars;

  private String symbol;

  @JsonAlias("next_page_token")
  private String nextPageToken;
}
