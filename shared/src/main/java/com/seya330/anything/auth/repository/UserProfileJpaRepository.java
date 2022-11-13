package com.seya330.anything.auth.repository;

import com.seya330.anything.auth.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserProfileJpaRepository extends CrudRepository<UserProfile, Long> {

  Optional<UserProfile> findByIdentity(String identity);
}
