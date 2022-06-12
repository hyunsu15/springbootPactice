package com.example.demo.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Test
  public void findByUuidTest(){
    User user=userRepository.save(UserTest.testUser());
    User resultUser = userRepository.findByUuid(user.getUuid()).get();
    assertEquals(user.getUuid(),resultUser.getUuid());
    assertEquals(user.getEmail(),resultUser.getEmail());

  }
}