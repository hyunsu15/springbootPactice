package com.example.demo.user.exception;

import com.example.demo.common.exception.BaseException;

public class NotFoundUserException extends BaseException {
  private static final  String MSG = "없는 유저 정보입니다.";
  public NotFoundUserException() {
    super(MSG);
  }
}
