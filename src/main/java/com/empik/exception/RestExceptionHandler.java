package com.empik.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(HttpClientErrorException.class)
  protected ResponseEntity<Object> handleEntityNotFound(
      HttpClientErrorException ex) {
    log.warn("Not able to retrieve user from external API: {}", ex.getMessage());
    return new ResponseEntity<>(NOT_FOUND);
  }

}
