package com.example.demo.todo.controller;

import com.example.demo.common.dto.LoginMember;
import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.todo.exception.RequestValidationException;
import com.example.demo.todo.service.ToDoService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/todo/")
public class TodoController {

  private final ToDoService toDoService;

  @PostMapping()
  public ResponseEntity<Void> createTodo(LoginMember loginMember,
      @Valid @RequestBody CreateTodoRequestDto request,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      throw new RequestValidationException();
    toDoService.createTodo(loginMember, request);
    return ResponseEntity.ok().build();
  }

}
