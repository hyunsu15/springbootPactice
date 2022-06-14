package com.example.demo.todo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.todo.domain.ToDo;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserTest;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ToDoRepositoryTest {
  @Autowired
  ToDoRepository toDoRepository;
  @Autowired
  UserRepository userRepository;

  User user;
  @BeforeEach
  void setUp() {
    user =userRepository.save(UserTest.testUser());
    for (int i = 0; i <10 ; i++) {
      toDoRepository.save(new ToDo(""+i,""+i,user));
    }
  }

  @Test
  void findByUserTest() {
    assertEquals(toDoRepository.findToDoByUserOrderByIdDesc(user,PageRequest.of(0,10)).size(), 10);
    assertEquals(toDoRepository.findToDoByUserOrderByIdDesc(user,PageRequest.of(0,1)).get(0).getContent(), "9");
  }
}