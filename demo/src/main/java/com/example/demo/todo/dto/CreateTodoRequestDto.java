package com.example.demo.todo.dto;


import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTodoRequestDto {

  @NotBlank
  private String title;
  @NotBlank
  private String content;

  public CreateTodoRequestDto(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
