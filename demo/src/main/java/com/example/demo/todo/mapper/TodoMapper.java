package com.example.demo.todo.mapper;

import com.example.demo.todo.domain.ToDo;
import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapper {

  TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

  ToDo toToDo(CreateTodoRequestDto createTodoRequestDto, User user);
}
