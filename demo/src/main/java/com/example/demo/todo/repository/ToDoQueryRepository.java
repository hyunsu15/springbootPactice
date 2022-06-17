package com.example.demo.todo.repository;

import com.example.demo.todo.domain.QToDo;
import com.example.demo.todo.domain.ToDo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ToDoQueryRepository {
  private final JPAQueryFactory jpaQueryFactory;

  public List<ToDo> findAll(){
    return jpaQueryFactory.select(QToDo.toDo)
        .from(QToDo.toDo)
        .stream().collect(Collectors.toList());
  }
  public List<String> findAllStr(){
    return jpaQueryFactory.select(QToDo.toDo)
        .from(QToDo.toDo)
        .stream()
        .map(x->x.getUser().getUuid())
        .collect(Collectors.toList());
  }
}
