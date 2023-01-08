package com.seya330.anything.todo.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TodoItemCompletedModifyRequest {

  @NotNull
  private Long seq;

  @NotNull
  private Boolean isCompleted;
}
