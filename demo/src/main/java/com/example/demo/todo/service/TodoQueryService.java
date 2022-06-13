package com.example.demo.todo.service;

import com.example.demo.common.dto.LoginMember;
import com.example.demo.todo.domain.ToDo;
import com.example.demo.todo.exception.NotFoundToDoException;
import com.example.demo.todo.repository.ToDoRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoQueryService {
  private final ToDoRepository todoRepository;
  private final UserService userService;
  public ToDo getToDo(LoginMember loginMember,Long toDoId){
    User user = userService.findUser(loginMember);
    return todoRepository.findByIdAndUser(toDoId,user).orElseThrow(NotFoundToDoException::new);
  }
}
