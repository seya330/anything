package com.seya330.anything.diary.repository;

import com.seya330.anything.diary.entity.Diary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryJpaRepository extends CrudRepository<Diary, Long> {
}
