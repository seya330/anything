package com.seya330.anything.auth.entity;


import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  private String identity;

  private String email;

  private String name;

  @Enumerated(EnumType.STRING)
  private LoginType loginType;
}


