package com.stonks.marketdata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bar {

  @JsonAlias("t")
  private OffsetDateTime time;

  @JsonAlias("o")
  private BigDecimal open;

  @JsonAlias("c")
  private BigDecimal close;

  @JsonAlias("h")
  private BigDecimal high;

  @JsonAlias("l")
  private BigDecimal low;

  @JsonAlias("v")
  private Long volume;
}
