package com.stonks.marketdata.exception;

import lombok.Builder;

@Builder
class ErrorResponse {
  private String message;
}
