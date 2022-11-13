package com.seya330.anything.diary.repository;

import com.querydsl.jpa.JPQLQuery;
import com.seya330.anything.diary.entity.Diary;
import com.seya330.anything.diary.query.DiaryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.seya330.anything.diary.entity.QDiary.diary;


@Repository
public class DiaryRepositoryImpl extends QuerydslRepositorySupport implements DiaryRepository {

  private final DiaryJpaRepository diaryJpaRepository;

  public DiaryRepositoryImpl(DiaryJpaRepository diaryJpaRepository) {
    super(Diary.class);
    this.diaryJpaRepository = diaryJpaRepository;
  }

  @Override
  public Optional<Diary> findById(Long seq) {
    return diaryJpaRepository.findById(seq);
  }

  @Override
  public Page<Diary> query(final DiaryQuery diaryQuery, final Pageable page) {
    final JPQLQuery<Diary> query = getQuerydsl().applyPagination(page,
        from(diary)
            .where(
                diary.registeredBy.eq(diaryQuery.getRegisteredBy()),
                diaryQuery.forPeriodSearch(diary)
            ));
    return new PageImpl<>(query.fetch(), page, query.fetchCount());
  }
}
