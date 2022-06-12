package com.example.demo.common.util;

import com.example.demo.common.dto.LoginMember;
import com.example.demo.user.domain.User;
import com.example.demo.user.exception.NotFoundUserException;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginMemberValidator {

  private final UserRepository userRepository;

  public LoginMember checkUuid(String uuid) {
    User user = userRepository.findByUuid(uuid).orElseThrow(NotFoundUserException::new);
    return new LoginMember(user.getUuid());
  }
}