package com.example.demo.common.util;


import com.example.demo.common.exception.BaseException;
import com.example.demo.common.exception.MapperErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper{
  private final ObjectMapper objectMapper;

  //Before,After
  public <B,A> A mapper(B before,Class<A> afterClass) {

    Map<String,Object> map= null;
    try {
      map = objectMapper.readValue(objectMapper.writeValueAsString(before), Map.class);
    } catch (JsonProcessingException e) {
      throw new MapperErrorException();
    }

    Set<String> fieldNames =Arrays.stream(afterClass.getDeclaredFields()).map(Field::getName).collect(Collectors.toSet());
    Map<String,Object> convertMap = new ConcurrentHashMap<>();

    for (String key : map.keySet()) {
      if(fieldNames.contains(key))
        convertMap.put(key,map.get(key));
    }

    return objectMapper.convertValue(convertMap,afterClass);
  }

}
