package com.seya330.anything.todo.service;

import com.seya330.anything.todo.constant.TodoItemStatus;
import com.seya330.anything.todo.dto.TodoItemRegister;
import com.seya330.anything.todo.entity.TodoItem;
import com.seya330.anything.todo.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoItemRegisterService {

  private final TodoItemRepository todoItemRepository;

  @Transactional
  public void register(final TodoItemRegister todoItemRegister) {
    final int maxOrder = todoItemRepository.getMaxOrder(todoItemRegister.getRegisteredBy());
    final LocalDate today = LocalDate.now();
    final TodoItem todoItem = TodoItem.builder()
        .contents(todoItemRegister.getContents())
        .status(TodoItemStatus.ADDED)
        .isStarred(Optional.ofNullable(todoItemRegister.getIsStarred()).orElse(false))
        .startedAt(Optional.ofNullable(todoItemRegister.getStartedAt()).orElse(today.atStartOfDay()))
        .endedAt(Optional.ofNullable(todoItemRegister.getEndedAt()).orElse(today.atTime(LocalTime.MAX)))
        .order(maxOrder + 1)
        .build();
    todoItemRepository.save(todoItem);
  }
}
