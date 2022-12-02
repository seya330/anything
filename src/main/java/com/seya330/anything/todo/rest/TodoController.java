package com.seya330.anything.todo.rest;

import com.seya330.anything.auth.utils.AuthUtils;
import com.seya330.anything.todo.converter.TodoItemResponseConverter;
import com.seya330.anything.todo.dto.TodoItemDto;
import com.seya330.anything.todo.dto.TodoItemSearchQuery;
import com.seya330.anything.todo.payload.TodoItemResponse;
import com.seya330.anything.todo.service.TodoItemQueryProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoItemQueryProcessor todoItemQueryProcessor;

  private final TodoItemResponseConverter todoItemResponseConverter;

  @GetMapping
  public ResponseEntity<Page<TodoItemResponse>> search(@PageableDefault Pageable page) {
    final Page<TodoItemDto> resultPage = todoItemQueryProcessor.search(TodoItemSearchQuery.builder()
        .registeredBy(AuthUtils.getUserId())
        .build(), page);
    return ResponseEntity.ok(todoItemResponseConverter.convert(resultPage));
  }
}
