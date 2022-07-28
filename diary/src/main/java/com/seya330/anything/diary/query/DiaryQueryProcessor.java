package com.seya330.anything.diary.query;

import com.seya330.anything.diary.entity.Diary;
import com.seya330.anything.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

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

  public Set<LocalDateTime> getDiaryRegisteredDate(final LocalDate startDate, final LocalDate endDate) {
    final Page<Diary> diaries = diaryRepository.query(DiaryQuery.builder()
        .periodSearch(DiaryQuery.PeriodSearch.builder()
            .periodSearchType(DiaryQuery.PeriodSearchType.REGISTERED_AT)
            .searchStartAt(startDate.atStartOfDay())
            .searchEndAt(endDate.atTime(LocalTime.MAX))
            .build())
        .build(), Pageable.unpaged());
    return diaries.stream().map(Diary::getRegisteredAt).collect(Collectors.toSet());
  }
}
