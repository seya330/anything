package com.seya330.anything.todo.entity;

import com.seya330.anything.common.BaseEntity;
import com.seya330.anything.todo.constant.TodoItemStatus;
import com.seya330.anything.todo.exception.TodoItemAlreadyCompletedException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TodoItem extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  private String contents;

  private boolean isCompleted;

  private boolean isStarred;

  private LocalDateTime startedAt;

  private LocalDateTime endedAt;

  private int numberOfOrder;

  private boolean isDeleted;

  public void complete() {
    isCompleted = true;
  }

  public void unCompleted() {
    isCompleted = false;
  }

  public void modifyStar(final boolean isStarred) {
    this.isStarred = isStarred;
  }

  public void delete() {
    this.isDeleted = true;
  }
}
