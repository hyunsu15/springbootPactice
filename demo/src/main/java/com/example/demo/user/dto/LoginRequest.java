package com.example.demo.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
  private String id;
  private String pwd;


  public LoginRequest(String id, String pwd) {
    this.id = id;
    this.pwd = pwd;
  }
}
