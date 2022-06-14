package com.example.demo.todo.mapper;

import com.example.demo.todo.domain.ToDo;
import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.todo.dto.ToDoResponseDto;
import com.example.demo.user.domain.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TodoMapper {

  ToDo createRequestToDo(CreateTodoRequestDto createTodoRequestDto, User user);
  ToDoResponseDto toDoToResponseDto(ToDo toDo);

}
