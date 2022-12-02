package com.seya330.anything.todo.repository;

import com.seya330.anything.todo.dto.TodoItemSearchQuery;
import com.seya330.anything.todo.entity.TodoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoItemRepository {

  int getMaxOrder(long registeredBy);

  TodoItem save(TodoItem todoItem);

  Page<TodoItem> search(final TodoItemSearchQuery query, final Pageable page);

  TodoItem findById(Long seq);
}
