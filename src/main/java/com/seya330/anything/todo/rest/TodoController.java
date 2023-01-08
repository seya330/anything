package com.seya330.anything.todo.rest;

import com.seya330.anything.auth.utils.AuthUtils;
import com.seya330.anything.todo.converter.TodoItemResponseConverter;
import com.seya330.anything.todo.dto.TodoItemDto;
import com.seya330.anything.todo.dto.TodoItemRegister;
import com.seya330.anything.todo.dto.TodoItemSearchQuery;
import com.seya330.anything.todo.payload.TodoItemCompletedModifyRequest;
import com.seya330.anything.todo.payload.TodoItemRegisterRequest;
import com.seya330.anything.todo.payload.TodoItemResponse;
import com.seya330.anything.todo.payload.TodoItemStarredModifyRequest;
import com.seya330.anything.todo.service.TodoItemQueryProcessor;
import com.seya330.anything.todo.service.TodoItemRegisterService;
import com.seya330.anything.todo.service.TodoItemModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoItemQueryProcessor todoItemQueryProcessor;

  private final TodoItemRegisterService todoItemRegisterService;

  private final TodoItemResponseConverter todoItemResponseConverter;

  private final TodoItemModifyService todoItemModifyService;

  @GetMapping
  public ResponseEntity<Page<TodoItemResponse>> search(@PageableDefault Pageable page) {
    final Page<TodoItemDto> resultPage = todoItemQueryProcessor.search(TodoItemSearchQuery.builder()
        .registeredBy(AuthUtils.getUserId())
        .build(), page);
    return ResponseEntity.ok(todoItemResponseConverter.convert(resultPage));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void register(@RequestBody @Valid final TodoItemRegisterRequest todoItemRegisterRequest) {
    final TodoItemRegister command = TodoItemRegister.builder()
        .contents(todoItemRegisterRequest.getContents())
        .isCompleted(todoItemRegisterRequest.getIsCompleted())
        .isStarred(todoItemRegisterRequest.getIsStarred())
        .startedAt(todoItemRegisterRequest.getStartedAt())
        .endedAt(todoItemRegisterRequest.getEndedAt())
        .registeredBy(AuthUtils.getUserId())
        .build();
    todoItemRegisterService.register(command);
  }

  @PutMapping("/starred")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void modifyStarred(@RequestBody @Valid final TodoItemStarredModifyRequest request) {
    todoItemModifyService.modifyStar(request.getSeq(), request.getIsStarred());
  }

  @PutMapping("/completed")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void modifyIsCompleted(@RequestBody @Valid final TodoItemCompletedModifyRequest request) {
    todoItemModifyService.modifyCompleted(request.getSeq(), request.getIsCompleted());
  }
}
