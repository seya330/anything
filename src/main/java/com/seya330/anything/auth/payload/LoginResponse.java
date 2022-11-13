package com.seya330.anything.auth.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

  private String token;

  private String email;

  private String name;
}
