package com.example.demo.common.dto;

import lombok.Getter;


@Getter
public class LoginMember {
  private String uuid;

  public LoginMember(String uuid) {
    this.uuid = uuid;
  }
}
