package com.example.demo.todo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.common.config.QueryDslConfig;
import com.example.demo.todo.domain.ToDo;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserTest;
import com.example.demo.user.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;

@Import(QueryDslConfig.class)
@DataJpaTest
class ToDoRepositoryTest {
  @Autowired
  ToDoRepository toDoRepository;
  @Autowired
  JPAQueryFactory jpaQueryFactory;
  @Autowired
  UserRepository userRepository;
  ToDoQueryRepository toDoQueryRepository;

  User user;
  @BeforeEach
  void setUp() {
    user =userRepository.save(UserTest.testUser());
    for (int i = 0; i <10 ; i++) {
      toDoRepository.save(new ToDo(""+i,""+i,user));
    }
    toDoQueryRepository = new ToDoQueryRepository(jpaQueryFactory);
  }

  @Test
  void findByUserTest() {
    assertEquals(toDoRepository.findToDoByUserOrderByIdDesc(user,PageRequest.of(0,10)).size(), 10);
    assertEquals(toDoRepository.findToDoByUserOrderByIdDesc(user,PageRequest.of(0,1)).get(0).getContent(), "9");
  }
  @Test
  void findByUserTest1() {
    for (int i = 0; i <10 ; i++) {
      toDoRepository.save(new ToDo(""+i,""+i,userRepository.save(UserTest.testUser(i+" "+i,i+" "+i))));
    }
    for (ToDo toDo : toDoRepository.findAll()) {
      System.out.println(toDo);
    }
  }

  @Test
  void rfindByUserTest2() {
    for (int i = 0; i <10 ; i++) {
      toDoRepository.save(new ToDo(""+i,""+i,userRepository.save(UserTest.testUser(i+" "+i,i+" "+i))));
    }
    toDoQueryRepository.findAllStr();

  }
  @Test
  void rfindByUserTest3() {

    toDoQueryRepository.findAllStr();
  }


}
