package com.seya330.anything.todo.converter;

import com.seya330.anything.common.PageConverterSupport;
import com.seya330.anything.todo.dto.TodoItemDto;
import com.seya330.anything.todo.entity.TodoItem;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoItemDtoConverter extends PageConverterSupport {

  TodoItemDto convert(TodoItem source);

  List<TodoItemDto> convert(List<TodoItem> source);

  default Page<TodoItemDto> convert(Page<TodoItem> source) {
    return convert(source, this::convert);
  }
}
