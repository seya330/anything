package com.seya330.anything.diary.query;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.seya330.anything.diary.entity.QDiary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryQuery {

  private PeriodSearch periodSearch;

  private Long registeredBy;

  public BooleanExpression forPeriodSearch(final QDiary qDiary) {
    if (periodSearch == null) return null;

    switch (periodSearch.periodSearchType) {
      case REGISTERED_AT:
        return qDiary.registeredAt.between(periodSearch.getSearchStartAt(), periodSearch.getSearchEndAt());
      default:
        return null;
    }
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class PeriodSearch {

    private PeriodSearchType periodSearchType;

    private LocalDateTime searchStartAt;

    private LocalDateTime searchEndAt;
  }

  public enum PeriodSearchType {
    REGISTERED_AT
  }
}
