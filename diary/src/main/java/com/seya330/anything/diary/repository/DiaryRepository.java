package com.seya330.anything.diary.repository;

import com.seya330.anything.diary.entity.Diary;
import com.seya330.anything.diary.query.DiaryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DiaryRepository {

  Optional<Diary> findById(Long seq);

  Page<Diary> query(DiaryQuery diaryQuery, Pageable page);
}
