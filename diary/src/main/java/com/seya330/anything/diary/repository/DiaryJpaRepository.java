package com.seya330.anything.diary.repository;

import com.seya330.anything.diary.entity.Diary;
import org.springframework.data.repository.CrudRepository;

public interface DiaryJpaRepository extends CrudRepository<Diary, Long> {
}
