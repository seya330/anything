package com.seya330.anything.auth.utils;

import com.seya330.anything.auth.exception.LoginFailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuthUtils {

  public static Long getUserId() {
    return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
        .map(Authentication::getPrincipal)
        .map(principal -> Long.parseLong((String) principal))
        .orElseThrow(LoginFailException::new);
  }
}
