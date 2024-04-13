package me.dio.controller.exception;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

public class GlobalExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
    return new ResponseEntity<>(businessException.getLocalizedMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
    return new ResponseEntity<>("Resource Id not found", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
    var message = "Unexpected server. erro. See the logs.";
    return new ResponseEntity<>("Unexpected server. erro. See the logs", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
