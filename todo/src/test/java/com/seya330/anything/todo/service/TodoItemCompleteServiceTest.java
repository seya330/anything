package com.seya330.anything.todo.service;

import com.seya330.anything.todo.constant.TodoItemStatus;
import com.seya330.anything.todo.entity.TodoItem;
import com.seya330.anything.todo.exception.TodoItemAlreadyCompletedException;
import com.seya330.anything.todo.repository.TodoItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TodoItemCompleteServiceTest {

  @InjectMocks
  TodoItemCompleteService todoItemCompleteService;

  @Mock
  TodoItemRepository todoItemRepository;

  @Test
  void complete() {
    final ArgumentCaptor<TodoItem> todoItemCaptor = ArgumentCaptor.forClass(TodoItem.class);
    given(todoItemRepository.findById(anyLong()))
        .willReturn(TodoItem.builder()
            .seq(1L)
            .contents("adfsadsf")
            .status(TodoItemStatus.ADDED)
            .isStarred(false)
            .startedAt(LocalDateTime.now())
            .endedAt(LocalDateTime.now())
            .order(1)
            .isDeleted(false)
            .build());
    todoItemCompleteService.complete(1L);
    verify(todoItemRepository).save(todoItemCaptor.capture());
    final TodoItem result = todoItemCaptor.getValue();
    assertThat(result.getStatus()).isEqualTo(TodoItemStatus.COMPLETED);
  }

  @Test
  void complete_alreadyCompleted() {
    final ArgumentCaptor<TodoItem> todoItemCaptor = ArgumentCaptor.forClass(TodoItem.class);
    given(todoItemRepository.findById(anyLong()))
        .willReturn(TodoItem.builder()
            .seq(1L)
            .contents("adfsadsf")
            .status(TodoItemStatus.COMPLETED)
            .isStarred(false)
            .startedAt(LocalDateTime.now())
            .endedAt(LocalDateTime.now())
            .order(1)
            .isDeleted(false)
            .build());

    assertThatThrownBy(() -> {
      todoItemCompleteService.complete(1L);
    }).isInstanceOf(TodoItemAlreadyCompletedException.class);
  }
}