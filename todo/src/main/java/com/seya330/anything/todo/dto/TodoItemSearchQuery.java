package com.seya330.anything.todo.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.LongFunction;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemSearchQuery {

  private Long registeredBy;

  public BooleanExpression forRegisteredBy(final LongFunction<BooleanExpression> fn) {
    return registeredBy != null ? fn.apply(registeredBy) : null;
  }
}
