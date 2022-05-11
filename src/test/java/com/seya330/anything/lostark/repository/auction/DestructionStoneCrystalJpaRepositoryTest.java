package com.seya330.anything.lostark.repository.auction;

import com.seya330.anything.config.JpaConfig;
import com.seya330.anything.lostark.domain.auction.DestructionStoneCrystal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
@Import(JpaConfig.class)
class DestructionStoneCrystalJpaRepositoryTest {

  @Autowired
  DestructionStoneCrystalJpaRepository destructionStoneCrystalJpaRepository;

  @Test
  @Rollback(value = false)
  void save() {
    destructionStoneCrystalJpaRepository.save(DestructionStoneCrystal.builder()
        .cost(1)
        .build());
  }
}