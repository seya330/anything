package com.seya330.anything.diary.service;

import com.seya330.anything.diary.entity.Diary;
import com.seya330.anything.diary.repository.DiaryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DiaryRegisterService {

  private final DiaryJpaRepository diaryJpaRepository;

  @Transactional
  public Long register(final String content, final Long registeredBy) {
    final Diary diary = diaryJpaRepository.save(Diary.builder()
        .content(content)
        .registeredBy(registeredBy)
        .build());
    return diary.getSeq();
  }
}
