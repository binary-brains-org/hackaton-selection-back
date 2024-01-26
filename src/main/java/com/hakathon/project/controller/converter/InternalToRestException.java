package com.hakathon.project.controller.converter;

import com.hakathon.project.controller.exception.BadRequestException;
import com.hakathon.project.controller.exception.ForbiddenException;
import com.hakathon.project.controller.exception.NotFoundException;
import com.hakathon.project.controller.exception.model.Exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class InternalToRestException {

  @ExceptionHandler(value = {BadRequestException.class})
  ResponseEntity<Exception> handleBadRequest(BadRequestException e) {
    log.info("Bad request", e);
    return new ResponseEntity<>(toRest(e, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {ForbiddenException.class})
  ResponseEntity<Exception> handleBadRequest(ForbiddenException e) {
    log.info("Bad request", e);
    return new ResponseEntity<>(toRest(e, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(value = {NotFoundException.class})
  ResponseEntity<Exception> handleBadRequest(NotFoundException e) {
    log.info("Bad request", e);
    return new ResponseEntity<>(toRest(e, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
  }

  private Exception toRest(java.lang.Exception e, HttpStatus status) {
    var restException = new Exception();
    restException.setType(status.toString());
    restException.setMessage(e.getMessage());
    return restException;
  }
}
