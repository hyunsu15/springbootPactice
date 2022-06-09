package com.example.demo.common.config;

import com.example.demo.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<String> exceptionError(Exception e){
    return ResponseEntity.badRequest().body(e.getMessage());
  }
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> unExceptionError(Exception e){
    log.error("error",e);
    return ResponseEntity.badRequest().body("예상치 못한 에러입니다.");
  }


}
