package com.seya330.anything.diary.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  private String content;
}
