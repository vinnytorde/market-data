package com.stonks.marketdata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Trade {
  @JsonAlias("t")
  private OffsetDateTime time;

  @JsonAlias("x")
  private String exchange;

  @JsonAlias("p")
  private BigDecimal price;

  @JsonAlias("s")
  private Long size;

  @JsonAlias("c")
  private List<String> conditions;

  @JsonAlias("i")
  private Long id;

  @JsonAlias("z")
  private String tape;
}
