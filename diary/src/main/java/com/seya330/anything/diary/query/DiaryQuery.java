package com.seya330.anything.diary.query;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.seya330.anything.diary.entity.QDiary;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class DiaryQuery {

  PeriodSearch periodSearch;

  public BooleanExpression forPeriodSearch(final QDiary qDiary) {
    if (periodSearch == null) return null;

    switch (periodSearch.periodSearchType) {
      case REGISTERED_AT:
        return qDiary.registeredAt.between(periodSearch.searchStartAt, periodSearch.getSearchEndAt());
      default:
        return null;
    }
  }

  @Value
  @Builder
  public static class PeriodSearch {

    PeriodSearchType periodSearchType;

    LocalDateTime searchStartAt;

    LocalDateTime searchEndAt;
  }

  public enum PeriodSearchType {
    REGISTERED_AT
  }
}
