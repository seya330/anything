package com.seya330.anything.lostark.repository.auction;

import com.seya330.anything.lostark.domain.auction.DestructionStoneCrystal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestructionStoneCrystalJpaRepository extends JpaRepository<DestructionStoneCrystal, Long> {
}
