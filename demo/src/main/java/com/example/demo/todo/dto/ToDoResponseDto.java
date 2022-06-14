package com.example.demo.todo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToDoResponseDto {
  private String title;
  private String content;
  @Builder
  public ToDoResponseDto(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
