package com.stonks.marketdata.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DateOutOfBoundsException extends Exception {
  public DateOutOfBoundsException(String message) {
    super(message);
  }
}
