package com.seya330.anything.todo.service;

import com.seya330.anything.todo.constant.TodoItemStatus;
import com.seya330.anything.todo.entity.TodoItem;
import com.seya330.anything.todo.repository.TodoItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TodoItemModifyServiceTest {

  @InjectMocks
  TodoItemModifyService todoItemModifyService;

  @Mock
  TodoItemRepository todoItemRepository;

  @Test
  void toggle() {
    final ArgumentCaptor<TodoItem> todoItemCaptor = ArgumentCaptor.forClass(TodoItem.class);
    given(todoItemRepository.findById(anyLong()))
        .willReturn(TodoItem.builder()
            .seq(1L)
            .contents("adfsadsf")
            .isCompleted(false)
            .isStarred(false)
            .startedAt(LocalDateTime.now())
            .endedAt(LocalDateTime.now())
            .numberOfOrder(1)
            .isDeleted(false)
            .build());

    todoItemModifyService.modifyStar(1L, true);
    verify(todoItemRepository).save(todoItemCaptor.capture());
    final TodoItem result = todoItemCaptor.getValue();
    assertThat(result.isStarred()).isTrue();
  }
}