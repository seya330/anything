package com.seya330.anything.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, AuthFilter authFilter) throws Exception {
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.authorizeRequests()
        .antMatchers("/auth/**").permitAll()
        .anyRequest().authenticated();
    http.exceptionHandling()
        .authenticationEntryPoint(new AuthEntryPoint())
        .accessDeniedHandler(new AuthAccessDenyHandler());
    http
        .cors()
        .and()
        .csrf()
        .disable();

    http.addFilterBefore(authFilter, BasicAuthenticationFilter.class);
    return http.build();
  }
}
