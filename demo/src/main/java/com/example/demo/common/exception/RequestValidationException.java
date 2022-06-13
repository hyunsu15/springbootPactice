package com.example.demo.common.exception;

public class RequestValidationException extends BaseException {
  private static final  String MSG = "잘못된 요청입니다.";
  public RequestValidationException() {
    super(MSG);
  }
}

