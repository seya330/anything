package com.seya330.anything.todo.service;

import com.seya330.anything.todo.entity.TodoItem;
import com.seya330.anything.todo.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoItemCompleteService {

  private final TodoItemRepository todoItemRepository;

  @Transactional
  public void complete(final Long seq) {
    final TodoItem todoItem = todoItemRepository.findById(seq);
    todoItem.complete();
    todoItemRepository.save(todoItem);
  }
}
