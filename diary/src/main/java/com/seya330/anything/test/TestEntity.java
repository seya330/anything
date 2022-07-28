package com.seya330.anything.test;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TestEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  @Builder.Default
  @OneToMany(mappedBy = "testEntity", cascade = CascadeType.ALL, orphanRemoval = true)
  @EqualsAndHashCode.Exclude
  private Set<TestSubEntity> subEntities = new LinkedHashSet<>();

  public void addSubEntity(final TestSubEntity testSubEntity) {
    this.subEntities.add(testSubEntity);
    testSubEntity.setTestEntity(this);
  }
}
