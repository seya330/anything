package com.seya330.anything.todo.service;

import com.seya330.anything.todo.constant.TodoItemStatus;
import com.seya330.anything.todo.dto.TodoItemRegister;
import com.seya330.anything.todo.entity.TodoItem;
import com.seya330.anything.todo.repository.TodoItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TodoItemRegisterServiceTest {

  @InjectMocks
  TodoItemRegisterService todoItemRegisterService;

  @Mock
  TodoItemRepository todoItemRepository;

  @Test
  void register() {
    given(todoItemRepository.getMaxOrder(anyLong())).willReturn(5);
    final TodoItemRegister arg = TodoItemRegister.builder()
        .contents("adsfasdfasdfasdf")
        .registeredBy(12345L)
        .build();
    todoItemRegisterService.register(arg);
    final ArgumentCaptor<TodoItem> captor = ArgumentCaptor.forClass(TodoItem.class);
    verify(todoItemRepository).save(captor.capture());
    assertThat(captor.getValue().getNumberOfOrder()).isEqualTo(6);
    assertThat(captor.getValue().getStartedAt()).isEqualTo(LocalDate.now().atStartOfDay());
    assertThat(captor.getValue().getEndedAt()).isEqualTo(LocalDate.now().atTime(LocalTime.MAX));
    assertThat(captor.getValue().getStatus()).isEqualTo(TodoItemStatus.ADDED);
  }

  @Test
  void register_applyDate() {
    given(todoItemRepository.getMaxOrder(anyLong())).willReturn(5);
    final LocalDateTime startedAt = LocalDateTime.of(2022, 1, 1, 10, 0, 0);
    final LocalDateTime endedAt = LocalDateTime.of(2022, 1, 1, 12, 0, 0);
    final TodoItemRegister arg = TodoItemRegister.builder()
        .contents("adsfasdfasdfasdf")
        .startedAt(startedAt)
        .endedAt(endedAt)
        .registeredBy(12345L)
        .isStarred(true)
        .build();
    todoItemRegisterService.register(arg);
    final ArgumentCaptor<TodoItem> captor = ArgumentCaptor.forClass(TodoItem.class);
    verify(todoItemRepository).save(captor.capture());
    assertThat(captor.getValue().getNumberOfOrder()).isEqualTo(6);
    assertThat(captor.getValue().getStartedAt()).isEqualTo(startedAt);
    assertThat(captor.getValue().getEndedAt()).isEqualTo(endedAt);
    assertThat(captor.getValue().getStatus()).isEqualTo(TodoItemStatus.ADDED);
    assertThat(captor.getValue().isStarred()).isTrue();
  }
}