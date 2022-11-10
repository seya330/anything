package com.seya330.anything.auth.dto;

import com.seya330.anything.auth.entity.LoginType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserProfileResult {

  long id;

  String email;

  String name;

  LoginType loginType;
}
