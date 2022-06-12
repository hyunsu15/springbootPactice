package com.example.demo.todo.exception;

import com.example.demo.common.exception.BaseException;

public class RequestValidationException extends BaseException {
  private static final  String MSG = "잘못된 요청입니다.";
  public RequestValidationException() {
    super(MSG);
  }
}

