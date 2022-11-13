package com.seya330.anything.auth.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.seya330.anything.auth.converter.UserProfileResultConverter;
import com.seya330.anything.auth.dto.UserProfileResult;
import com.seya330.anything.auth.entity.LoginType;
import com.seya330.anything.auth.entity.UserProfile;
import com.seya330.anything.auth.exception.LoginFailException;
import com.seya330.anything.auth.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoogleLoginService {

  private final GoogleIdTokenVerifier googleVerifier;

  private final UserProfileRepository userProfileRepository;

  private final UserProfileResultConverter userProfileResultConverter;

  @Transactional
  public UserProfileResult login(final String token) {
    GoogleIdToken idToken = null;
    try {
      idToken = googleVerifier.verify(token);
    } catch (GeneralSecurityException | IOException e) {
      e.printStackTrace();
      throw new LoginFailException();
    }
    if (idToken != null) {
      final GoogleIdToken.Payload payload = idToken.getPayload();
      final String subject = payload.getSubject();
      final String email = payload.getEmail();
      final String name = (String) Optional.ofNullable(payload.get("name")).orElse(null);
      final UserProfile user = userProfileRepository.save(userProfileRepository.findByIdentity(subject)
          .map(e -> {
            e.setEmail(email);
            e.setName(name);
            return e;
          })
          .orElseGet(() -> UserProfile.builder()
              .identity(subject)
              .email(email)
              .name(name)
              .loginType(LoginType.GOOGLE)
              .build()
          ));
      return userProfileResultConverter.convert(user);
    }
    throw new LoginFailException();
  }
}
