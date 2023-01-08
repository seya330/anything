package com.seya330.anything.todo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Getter
public class TodoItemRegister {

  final String contents;

  final Boolean isCompleted;

  final Boolean isStarred;

  final LocalDateTime startedAt;

  final LocalDateTime endedAt;

  final Long registeredBy;
}
