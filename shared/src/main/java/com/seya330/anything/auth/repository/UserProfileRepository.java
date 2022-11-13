package com.seya330.anything.auth.repository;

import com.seya330.anything.auth.entity.UserProfile;

import java.util.Optional;

public interface UserProfileRepository {

  UserProfile save(UserProfile userProfile);

  Optional<UserProfile> findByIdentity(String identity);
}
