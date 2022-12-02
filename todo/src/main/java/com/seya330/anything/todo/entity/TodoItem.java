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

  @Enumerated(EnumType.STRING)
  private TodoItemStatus status;

  private boolean isStarred;

  private LocalDateTime startedAt;

  private LocalDateTime endedAt;

  private int order;

  private boolean isDeleted;

  public void complete() {
    if (status == TodoItemStatus.COMPLETED) {
      throw new TodoItemAlreadyCompletedException();
    }
    status = TodoItemStatus.COMPLETED;
  }

  public void toggleStar() {
    isStarred = !isStarred;
  }
}
