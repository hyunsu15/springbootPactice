package com.example.demo.todo.service;


import com.example.demo.common.dto.LoginMember;
import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.todo.mapper.TodoMapper;
import com.example.demo.todo.repository.ToDoRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ToDoService {

  private final ToDoRepository todoRepository;
  private final UserService userService;

  @Transactional
  public void createTodo(LoginMember loginMember, CreateTodoRequestDto requestDto) {
    User user = userService.findUser(loginMember);
    todoRepository.save(TodoMapper.INSTANCE.toToDo(requestDto, user));
  }
}
