package com.seya330.anything.auth.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AuthRequest {

  private String token;
}
