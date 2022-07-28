package com.seya330.anything.common;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.lang.Nullable;

public interface ToPredicate {

  @Nullable
  BooleanExpression apply();


  interface P1<T> {
    @Nullable
    BooleanExpression apply(T t);
  }

  interface P2<T, T2> {
    @Nullable
    BooleanExpression apply(T t, T2 t2);
  }
}
