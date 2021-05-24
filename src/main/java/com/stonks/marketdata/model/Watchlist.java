package com.stonks.marketdata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Watchlist {

  private UUID id;

  private String name;

  @JsonAlias("account_id")
  private UUID accountId;

  @JsonAlias("created_at")
  private OffsetDateTime created;

  @JsonAlias("updated_at")
  private OffsetDateTime updated;

  private List<Asset> assets;

  private List<String> symbols;
}
