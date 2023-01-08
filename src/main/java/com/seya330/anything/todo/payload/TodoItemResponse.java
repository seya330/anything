package com.seya330.anything.todo.payload;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class TodoItemResponse {

  Long seq;

  String contents;

  Boolean isCompleted;

  Boolean isStarred;

  LocalDateTime startedAt;

  LocalDateTime endedAt;

  Integer numberOfOrder;
}
