package com.seya330.anything.test;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class TestSubEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @ManyToOne
  @JoinColumn(name = "testEntitySeq")
  @EqualsAndHashCode.Exclude
  private TestEntity testEntity;

  @ManyToOne
  @JoinColumn(name = "testTwoEntitySeq")
  @EqualsAndHashCode.Exclude
  private TestTwoEntity testTwoEntity;
}
