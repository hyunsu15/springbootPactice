package com.example.demo.todo.repository;


import com.example.demo.todo.domain.ToDo;
import com.example.demo.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
  public Optional<ToDo> findByIdAndUser(Long id, User user);
}
