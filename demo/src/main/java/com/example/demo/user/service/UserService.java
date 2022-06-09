package com.example.demo.user.service;

import com.example.demo.common.util.Mapper;
import com.example.demo.user.domain.User;
import com.example.demo.user.dto.LoginRequest;
import com.example.demo.user.dto.LoginResponse;
import com.example.demo.user.exception.NotFoundUserException;
import com.example.demo.user.repository.UserQueryRepository;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final Mapper mapper;
  private final UserQueryRepository userQueryRepository;
  public LoginResponse login(LoginRequest loginRequest){
    return mapper.mapper(userQueryRepository.existUser(loginRequest).orElseThrow(NotFoundUserException::new),LoginResponse.class);
  }
  public User findById(long id){
    return userRepository.findById(id).orElseThrow(NotFoundUserException::new);
  }

}
