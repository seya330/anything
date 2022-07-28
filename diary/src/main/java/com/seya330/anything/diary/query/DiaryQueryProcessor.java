package com.seya330.anything.diary.query;

import com.seya330.anything.diary.entity.Diary;
import com.seya330.anything.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryQueryProcessor {

  private final DiaryRepository diaryRepository;

  public Diary get(final Long seq) {
    return diaryRepository.findById(seq).orElseThrow(NullPointerException::new);
  }

  public Page<Diary> get(final DiaryQuery diaryQuery, final Pageable pageable) {
    return diaryRepository.query(diaryQuery, pageable);
  }
}
