package com.seya330.anything.todo.repository;

import com.seya330.anything.todo.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemJpaRepository extends CrudRepository<TodoItem, Long> {
}
