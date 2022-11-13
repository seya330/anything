package com.seya330.anything.auth.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtUtils {

  private final AuthProperties authProperties;

  private static final String ISSUER = "anything.com";

  private static final long expiredTime = 1000 * 60 * 60 * 2;

  private static final String BEARER ="Bearer ";


  public String createToken(final String key) {
    Map<String, Object> header = Jwts.header();
    final Date expireDate = new Date(System.currentTimeMillis() + expiredTime);
    final Claims claims = Jwts.claims()
        .setIssuer(ISSUER)
        .setSubject(key)
        .setAudience("")
        .setExpiration(expireDate)
        .setNotBefore(new Date())
        .setIssuedAt(new Date());
    final SecretKeySpec keySpec =
        new SecretKeySpec(authProperties.getJwtSecretKey().getBytes(), SignatureAlgorithm.HS256.getJcaName());
    return BEARER + Jwts.builder()
        .setHeader(header)
        .setClaims(claims)
        .signWith(keySpec)
        .compact();
  }

  public Claims verify(String token) {
    try {
      token = token.replaceAll(BEARER, "");
      return Jwts.parserBuilder()
          .setSigningKey(authProperties.getJwtSecretKey().getBytes())
          .build()
          .parseClaimsJws(token)
          .getBody();
    } catch (ExpiredJwtException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
