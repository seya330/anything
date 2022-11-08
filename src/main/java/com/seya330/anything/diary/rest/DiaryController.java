package com.seya330.anything.diary.rest;

import com.seya330.anything.diary.entity.Diary;
import com.seya330.anything.diary.payload.DiaryPostRequest;
import com.seya330.anything.diary.query.DiaryQuery;
import com.seya330.anything.diary.query.DiaryQueryProcessor;
import com.seya330.anything.diary.service.DiaryRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/diaries")
@RequiredArgsConstructor
public class DiaryController {

  private final DiaryRegisterService diaryRegisterService;

  private final DiaryQueryProcessor diaryQueryProcessor;

  @PostMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void register(@RequestBody @Valid final DiaryPostRequest diaryPostRequest) {
    diaryRegisterService.register(diaryPostRequest.getContent());
  }

  @GetMapping("/{seq}")
  public ResponseEntity<Diary> getDiary(@PathVariable final Long seq) {
    return ResponseEntity.ok(diaryQueryProcessor.get(seq));
  }

  @GetMapping
  public ResponseEntity<Page<Diary>> getDiaries(@PageableDefault final Pageable pageable, @ModelAttribute final DiaryQuery diaryQuery) {
    return ResponseEntity.ok(diaryQueryProcessor.get(diaryQuery, pageable));
  }

  @GetMapping("/registered-date")
  public ResponseEntity<Map<LocalDateTime, Long>> getRegisteredDiary(final LocalDate startDate, final LocalDate endDate) {
    return ResponseEntity.ok(diaryQueryProcessor.getDiaryRegistered(startDate, endDate));
  }
}
