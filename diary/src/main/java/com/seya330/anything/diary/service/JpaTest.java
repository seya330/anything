package com.seya330.anything.diary.service;

import com.seya330.anything.test.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JpaTest {

  private final TestJpaRepository testJpaRepository;

  private final TestTwoJpaRepository testTwoJpaRepository;

  @Transactional
  public void test() {
    final TestEntity entity = new TestEntity();
    final TestTwoEntity entity2 = testTwoJpaRepository.save(new TestTwoEntity());
//    final TestTwoEntity entity2 = new TestTwoEntity();
    final TestSubEntity sub = new TestSubEntity();

    entity.addSubEntity(sub);
    sub.setTestTwoEntity(entity2);

    testJpaRepository.save(entity);
  }

  @Transactional
  public void test2() {
    final TestEntity entity = testJpaRepository.findById(8L).get();
    entity.getSubEntities().clear();
  }
}
