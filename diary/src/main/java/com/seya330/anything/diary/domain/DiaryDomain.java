package com.seya330.anything.diary.domain;

import com.seya330.anything.diary.entity.Diary;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class DiaryDomain {

  private final Diary diary;
}
