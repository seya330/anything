package com.seya330.anything.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestJpaRepository extends JpaRepository<TestEntity, Long> {
}
