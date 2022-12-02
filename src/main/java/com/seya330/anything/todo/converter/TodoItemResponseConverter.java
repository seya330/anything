package com.seya330.anything.todo.converter;

import com.seya330.anything.common.PageConverterSupport;
import com.seya330.anything.todo.dto.TodoItemDto;
import com.seya330.anything.todo.payload.TodoItemResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoItemResponseConverter extends PageConverterSupport {

  TodoItemResponse convert(TodoItemDto source);

  List<TodoItemResponse> convert(List<TodoItemDto> source);

  default Page<TodoItemResponse> convert(Page<TodoItemDto> source) {
    return convert(source, this::convert);
  }
}
