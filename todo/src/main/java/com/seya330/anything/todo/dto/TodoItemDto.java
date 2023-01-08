package com.seya330.anything.todo.dto;

import com.seya330.anything.todo.constant.TodoItemStatus;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class TodoItemDto {

  Long seq;

  String contents;

  Boolean isCompleted;

  Boolean isStarred;

  LocalDateTime startedAt;

  LocalDateTime endedAt;

  Integer numberOfOrder;

  Boolean isDeleted;
}
