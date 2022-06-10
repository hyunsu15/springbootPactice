package com.example.demo.common.util;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.common.exception.MapperErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
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

class Mapper{
  private final ObjectMapper objectMapper;

  public Mapper(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  //Before,After
  public <B,A> A mapper(B before,Class<A> afterClass) {

    Map<String,Object> map= null;
    try {
      map = objectMapper.readValue(objectMapper.writeValueAsString(before), Map.class);
    } catch (JsonProcessingException e) {
      throw new MapperErrorException();
    }

    Set<String> fieldNames = Arrays.stream(afterClass.getDeclaredFields()).map(Field::getName).collect(
        Collectors.toSet());
    Map<String,Object> convertMap = new ConcurrentHashMap<>();

    for (String key : map.keySet()) {
      if(fieldNames.contains(key))
        convertMap.put(key,map.get(key));
    }

    return objectMapper.convertValue(convertMap,afterClass);
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
