package com.seya330.anything.diary.rest;

import com.seya330.anything.diary.entity.Diary;
import com.seya330.anything.diary.payload.DiaryPostRequest;
import com.seya330.anything.diary.repository.DiaryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/diary")
@RequiredArgsConstructor
public class DiaryController {

  private final DiaryJpaRepository diaryJpaRepository;

  @PostMapping
  public void register(@RequestBody @Valid final DiaryPostRequest diaryPostRequest) {
    diaryJpaRepository.save(Diary.builder()
        .content(diaryPostRequest.getContent())
        .build());
  }

  @GetMapping("/{seq}")
  public Diary getDiary(@PathVariable Long seq) {
    return diaryJpaRepository.findById(seq).orElseThrow(NullPointerException::new);
  }
}
