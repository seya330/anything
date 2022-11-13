package com.seya330.anything.auth.rest;

import com.seya330.anything.auth.dto.UserProfileResult;
import com.seya330.anything.auth.payload.AuthRequest;
import com.seya330.anything.auth.payload.LoginResponse;
import com.seya330.anything.auth.service.GoogleLoginService;
import com.seya330.anything.auth.config.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

  private final JwtUtils jwtUtils;

  private final GoogleLoginService googleLoginService;

  @PostMapping("/google")
  public ResponseEntity<LoginResponse> googleLogin(@RequestBody final AuthRequest authRequest) {
    final UserProfileResult user = googleLoginService.login(authRequest.getToken());
    final LoginResponse loginResponse = LoginResponse.builder()
        .name(user.getName())
        .email(user.getEmail())
        .token(jwtUtils.createToken(String.valueOf(user.getSeq())))
        .build();
    return ResponseEntity.ok()
        .body(loginResponse);
  }

}
