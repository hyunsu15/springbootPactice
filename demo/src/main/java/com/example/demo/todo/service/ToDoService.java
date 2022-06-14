package com.example.demo.todo.service;


import com.example.demo.common.dto.LoginMember;
import com.example.demo.todo.domain.ToDo;
import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.todo.dto.ToDoResponseDto;
import com.example.demo.todo.dto.UpdateTodoRequestDto;
import com.example.demo.todo.mapper.TodoMapper;
import com.example.demo.todo.repository.ToDoRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
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
  public void deleteTodo(LoginMember loginMember, Long toDoId) {
    ToDo toDo = todoQueryService.getToDo(loginMember,toDoId);
    todoRepository.delete(toDo);
  }
  public List<ToDoResponseDto> readTodo(LoginMember loginMember, Pageable pageable) {

    return todoRepository.findToDoByUserOrderByIdDesc(userService.findUser(loginMember),pageable)
        .stream()
        .map(mapper::toDoToResponseDto)
        .collect(Collectors.toList());
  }

}
