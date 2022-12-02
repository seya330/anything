package com.seya330.anything.todo.service;

import com.seya330.anything.todo.entity.TodoItem;
import com.seya330.anything.todo.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoItemStarToggleService {

  private final TodoItemRepository todoItemRepository;

  public void toggle(final Long seq) {
    final TodoItem todoItem = todoItemRepository.findById(seq);
    todoItem.toggleStar();
    todoItemRepository.save(todoItem);
  }
}
