package com.seya330.anything.todo.dto;

import com.seya330.anything.todo.constant.TodoItemStatus;
import lombok.Builder;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Value
@Builder
public class TodoItemDto {

  Long seq;

  String contents;

  TodoItemStatus status;

  Boolean isStarred;

  LocalDateTime startedAt;

  LocalDateTime endedAt;

  Integer order;

  Boolean isDeleted;
}
