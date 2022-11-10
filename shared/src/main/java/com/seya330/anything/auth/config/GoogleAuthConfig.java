package com.seya330.anything.auth.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class GoogleAuthConfig {

  @Bean
  public GoogleIdTokenVerifier googleVerifier() {
    return new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
        .setAudience(Collections.singletonList("151749810455-43v7cd4lnk8j09ftf98j2eu0bt5f77oa.apps.googleusercontent.com"))
        .build();
  }

}
