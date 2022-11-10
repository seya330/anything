package com.seya330.anything.auth.rest;

import com.seya330.anything.auth.converter.UserProfileResponseConverter;
import com.seya330.anything.auth.dto.UserProfileResult;
import com.seya330.anything.auth.payload.AuthRequest;
import com.seya330.anything.auth.payload.UserProfileResponse;
import com.seya330.anything.auth.service.GoogleLoginService;
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

  private final GoogleLoginService googleLoginService;

  private final UserProfileResponseConverter userProfileResponseConverter;

  @PostMapping("/google")
  public ResponseEntity<UserProfileResponse> googleLogin(@RequestBody final AuthRequest authRequest) {
    final UserProfileResult user = googleLoginService.login(authRequest.getToken());
    return ResponseEntity.ok()
        .body(userProfileResponseConverter.convert(user));
  }

}
