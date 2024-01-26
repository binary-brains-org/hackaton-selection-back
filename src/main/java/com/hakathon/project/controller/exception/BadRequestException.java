package com.hakathon.project.controller.exception;

import static com.hakathon.project.controller.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;

public class BadRequestException extends ApiException{

  public BadRequestException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
