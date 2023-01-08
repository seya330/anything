package com.seya330.anything.todo.service;

import com.seya330.anything.todo.entity.TodoItem;
import com.seya330.anything.todo.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoItemModifyService {

  private final TodoItemRepository todoItemRepository;

  @Transactional
  public void modifyStar(final Long seq, final Boolean isStarred) {
    final TodoItem todoItem = todoItemRepository.findById(seq);
    todoItem.modifyStar(isStarred);
    todoItemRepository.save(todoItem);
  }

  public void modifyCompleted(final Long seq, final Boolean isCompleted) {
    final TodoItem todoItem = todoItemRepository.findById(seq);
    if (isCompleted) {
      todoItem.complete();
    } else {
      todoItem.unCompleted();
    }
    todoItemRepository.save(todoItem);
  }
}
