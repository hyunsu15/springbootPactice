package com.example.demo.todo.domain;

import com.example.demo.user.domain.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
public class ToDo{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  public ToDo(String title, String content, User user) {
    this.title = title;
    this.content = content;
    this.user = user;
  }
}
