package com.seya330.anything.auth.config;

import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotBlank;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

  JwtUtils jwtUtils = new JwtUtils(new AuthProperties("151749810455-43v7cd4lnk8j09ftf98j2eu0bt5f77oa.apps.googleusercontent.com", "53J3su8NiGxb4JRCXlOPQk_BbpqBkkm5UEJ_fjyVsqIWD7RwQ6OXaGz1hmbUEAGjss-aw4LGtUNYvQ44qW2EBI3hpp_mlhN-qM6ajCeKF3BPTWX25lHTl-5E31Xo0xoP-6Tf_fA-rVJHHNMWh2bO0Oq4KomFCTQ_erNqC7chASs"));

  @Test
  void getToken() {
    System.out.println(jwtUtils.createToken("2"));
  }
}