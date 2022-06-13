package com.example.demo.todo.exception;

import com.example.demo.common.exception.BaseException;

public class NotFoundToDoException extends BaseException {
  private static final  String MSG = "없는 할일 정보입니다.";
  public NotFoundToDoException() {
    super(MSG);
  }
}
