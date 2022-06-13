package com.example.demo.todo.service;


import com.example.demo.common.dto.LoginMember;
import com.example.demo.todo.domain.ToDo;
import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.todo.dto.UpdateTodoRequestDto;
import com.example.demo.todo.mapper.TodoMapper;
import com.example.demo.todo.repository.ToDoRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ToDoService {

  private final ToDoRepository todoRepository;
  private final UserService userService;
  private final TodoQueryService todoQueryService;
  private final TodoMapper mapper;
  public void createTodo(LoginMember loginMember, CreateTodoRequestDto requestDto) {
    User user = userService.findUser(loginMember);
    todoRepository.save(mapper.createRequestToDo(requestDto, user));
  }
  public void updateTodo(LoginMember loginMember, UpdateTodoRequestDto requestDto,Long toDoId) {
    ToDo toDo = todoQueryService.getToDo(loginMember,toDoId);
    toDo.updateToDo(requestDto);

  }

}
