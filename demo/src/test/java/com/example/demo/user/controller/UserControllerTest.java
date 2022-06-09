package com.example.demo.user.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserTest;
import com.example.demo.user.dto.LoginRequest;
import com.example.demo.user.dto.LoginResponse;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  UserRepository userRepository;

  @Test
  void loginTest() throws Exception {
    User user =  userRepository.save(UserTest.testUser());
    LoginRequest loginRequest = new LoginRequest("1","1");

    MockHttpServletResponse response = mockMvc.perform(
        post("/user/login")
        .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loginRequest))
        )
        .andReturn().getResponse();
    assertEquals( HttpStatus.OK.value(),response.getStatus());
    LoginResponse loginResponse = objectMapper.readValue(response.getContentAsString(),LoginResponse.class);
    assertEquals(loginResponse.getUuid(),user.getUuid());
  }

}