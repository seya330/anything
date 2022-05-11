package com.seya330.anything.diary.payload;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DiaryPostRequest {

  @NotEmpty
  private String content;
}
