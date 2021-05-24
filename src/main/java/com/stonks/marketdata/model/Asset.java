package com.stonks.marketdata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Asset {
  private UUID id;

  @JsonAlias("class")
  private String assetClass;

  private String exchange;
  private String symbol;
  private String name;
  private String status;
  private Boolean tradable;
  private Boolean marginable;
  private Boolean shortable;
  private Boolean fractionable;

  @JsonAlias("easy_to_borrow")
  private Boolean easyToBorrow;
}
