package com.example.demo.user.repository;

import com.example.demo.user.domain.QUser;
import com.example.demo.user.domain.User;
import com.example.demo.user.dto.LoginRequest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository  {
  private final JPAQueryFactory jpaQueryFactory;
 public Optional<User> existUser(LoginRequest loginRequest) {
    QUser user = QUser.user;

    return jpaQueryFactory
        .select(user)
        .from(user)
        .where(
        user.email.eq(loginRequest.getId())
            .and(user.pwd.eq(loginRequest.getPwd()))
    ).stream().findAny();
  }
}
