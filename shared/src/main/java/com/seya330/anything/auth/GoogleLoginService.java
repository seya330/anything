package com.seya330.anything.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class GoogleLoginService {

  public void login(final String token) {
    final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
        new NetHttpTransport(), GsonFactory.getDefaultInstance()
    ).setAudience(Collections.singletonList("151749810455-43v7cd4lnk8j09ftf98j2eu0bt5f77oa.apps.googleusercontent.com")).build();

    GoogleIdToken idToken = null;
    try {
      idToken = verifier.verify(token);
    } catch (GeneralSecurityException | IOException e) {
      e.printStackTrace();
    }
    if (idToken != null) {
      final GoogleIdToken.Payload payload = idToken.getPayload();
      final String email = payload.getEmail();
      final String name = (String) payload.get("name");
      final String locale = (String) payload.get("locale");
      final String familyName = (String) payload.get("family_name");

      System.out.println(email + " " + name + " " + locale + " " + familyName);
    }
  }
}
