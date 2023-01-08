package com.seya330.anything.todo.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TodoItemRegisterRequest {

  @NotEmpty
  private String contents;

  @NotNull
  private Boolean isCompleted;

  @NotNull
  private Boolean isStarred;

  private LocalDateTime startedAt;

  private LocalDateTime endedAt;
}
