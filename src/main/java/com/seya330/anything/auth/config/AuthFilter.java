package com.seya330.anything.auth.config;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {

  private final JwtUtils jwtUtils;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
        .ifPresent(token -> {
          Claims claims = jwtUtils.verify(token);
          Authentication auth = new PreAuthenticatedAuthenticationToken(claims.getSubject(), token,
              Collections.singletonList(new OAuth2UserAuthority(claims)));
          SecurityContextHolder.getContext().setAuthentication(auth);
        });
    filterChain.doFilter(request, response);
  }
}
