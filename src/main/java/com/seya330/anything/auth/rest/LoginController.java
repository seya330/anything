package com.seya330.anything.auth.rest;

import com.seya330.anything.auth.GoogleLoginService;
import com.seya330.anything.auth.payload.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

  private final GoogleLoginService googleLoginService;

  @PostMapping("/google")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void googleLogin(@RequestBody final AuthRequest authRequest) {
    googleLoginService.login(authRequest.getToken());
  }

}
