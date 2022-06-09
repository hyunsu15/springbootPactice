package com.example.demo.common.exception;

public class MapperErrorException extends BaseException {
  private static final  String MSG = "mapper 문제입니다.서비측에 문의해주세요.";
  public MapperErrorException() {
    super(MSG);
  }
}

