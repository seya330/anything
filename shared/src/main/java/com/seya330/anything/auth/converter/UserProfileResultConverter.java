package com.seya330.anything.auth.converter;

import com.seya330.anything.auth.dto.UserProfileResult;
import com.seya330.anything.auth.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileResultConverter {

  UserProfileResult convert(UserProfile userProfile);
}
