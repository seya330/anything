package com.seya330.anything.todo.service;

import com.seya330.anything.todo.converter.TodoItemDtoConverter;
import com.seya330.anything.todo.dto.TodoItemDto;
import com.seya330.anything.todo.dto.TodoItemSearchQuery;
import com.seya330.anything.todo.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoItemQueryProcessor {

  private final TodoItemRepository todoItemRepository;

  private final TodoItemDtoConverter todoItemDtoConverter;

  public Page<TodoItemDto> search(final TodoItemSearchQuery query, final Pageable page) {
    return todoItemDtoConverter.convert(todoItemRepository.search(query, page));
  }
}
