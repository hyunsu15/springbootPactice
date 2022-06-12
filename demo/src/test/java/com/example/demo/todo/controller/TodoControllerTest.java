package com.example.demo.todo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserTest;
import com.example.demo.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class TodoControllerTest {

  @Autowired
  MockMvc mockMvc;
  @Autowired
  UserRepository userRepository;
  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void createToDoTest() throws Exception {
    User user = userRepository.save(UserTest.testUser());

    MockHttpServletResponse response = mockMvc.perform(post("/todo/")
        .header("uuid", user.getUuid())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(new CreateTodoRequestDto("1", "1")))
    ).andReturn().getResponse();

    assertEquals(HttpStatus.OK.value(), response.getStatus());
    assertEquals(userRepository.findAll().size(), 1);

  }
}

