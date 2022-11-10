package com.seya330.anything.auth.converter;

import com.seya330.anything.auth.dto.UserProfileResult;
import com.seya330.anything.auth.payload.UserProfileResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileResponseConverter {

  UserProfileResponse convert(UserProfileResult userProfileResult);
}
