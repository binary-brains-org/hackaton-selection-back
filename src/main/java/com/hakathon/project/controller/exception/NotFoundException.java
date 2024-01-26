package com.hakathon.project.controller.exception;

import static com.hakathon.project.controller.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;

public class NotFoundException extends ApiException{

  public NotFoundException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
