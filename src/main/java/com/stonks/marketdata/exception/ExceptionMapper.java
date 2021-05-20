package com.stonks.marketdata.exception;

import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionMapper {

  @ExceptionHandler(DateOutOfBoundsException.class)
  public ResponseEntity<ErrorResponse> handleDateOutOfBoundsException(DateOutOfBoundsException e) {
    val error = ErrorResponse.builder().message(e.getMessage()).build();
    return ResponseEntity.badRequest().body(error);
  }
}
