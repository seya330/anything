package com.seya330.anything.todo.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TodoItemStarredModifyRequest {

  @NotNull
  private Long seq;

  @NotNull
  private Boolean isStarred;
}
