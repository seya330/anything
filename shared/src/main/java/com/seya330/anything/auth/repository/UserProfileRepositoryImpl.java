package com.seya330.anything.auth.repository;

import com.seya330.anything.auth.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserProfileRepositoryImpl implements UserProfileRepository {

  private final UserProfileJpaRepository userProfileJpaRepository;

  @Override
  public UserProfile save(final UserProfile userProfile) {
    return userProfileJpaRepository.save(userProfile);
  }

  @Override
  public Optional<UserProfile> findByIdentity(final String identity) {
    return userProfileJpaRepository.findByIdentity(identity);
  }
}
