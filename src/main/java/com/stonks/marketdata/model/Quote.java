package com.stonks.marketdata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Quote {
  @JsonAlias("t")
  private OffsetDateTime time;

  @JsonAlias("ax")
  private String exchange;

  @JsonAlias("ap")
  private String askPrice;

  @JsonAlias("as")
  private Long askSize;

  @JsonAlias("bx")
  private String bidExchange;

  @JsonAlias("bp")
  private BigDecimal bidPrice;

  @JsonAlias("bs")
  private Long bidSize;

  @JsonAlias("c")
  private List<String> conditions;
}
