package com.example.demo.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class UserTest {

  public static User testUser(){
    return new User(1L,"1","1", UUID.randomUUID().toString());
  }
  public static User testUser(String email,String pwd){
    return new User(1L,email,pwd, UUID.randomUUID().toString());
  }
}