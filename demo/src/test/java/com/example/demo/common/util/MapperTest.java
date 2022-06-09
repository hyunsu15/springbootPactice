package com.example.demo.common.util;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class MapperTest {

  @Test
  public void mapperTest() {
    B b = new B(1,3);
    Mapper mapper =new Mapper(new ObjectMapper());
    A a=mapper.mapper(b,A.class);
    assertEquals(1,a.getB());
    assertEquals(0,a.getA());
  }
}

class B{
  private int b;
  private int c;

  public B(int b, int c) {
    this.b = b;
    this.c = c;
  }

  public int getB() {
    return b;
  }

  public int getC() {
    return c;
  }
}
class A{
  private int a;
  private int b;

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }
}
