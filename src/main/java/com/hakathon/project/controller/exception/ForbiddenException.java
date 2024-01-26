package com.hakathon.project.controller.exception;

import static com.hakathon.project.controller.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;

public class ForbiddenException extends ApiException{

  public ForbiddenException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
