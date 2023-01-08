package com.seya330.anything.todo.repository;

import com.querydsl.jpa.JPQLQuery;
import com.seya330.anything.todo.dto.TodoItemSearchQuery;
import com.seya330.anything.todo.entity.TodoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static com.seya330.anything.todo.entity.QTodoItem.todoItem;

@Repository
public class TodoItemRepositoryImpl extends QuerydslRepositorySupport implements TodoItemRepository {

  private final TodoItemJpaRepository todoItemJpaRepository;

  public TodoItemRepositoryImpl(final TodoItemJpaRepository todoItemJpaRepository) {
    super(TodoItem.class);
    this.todoItemJpaRepository = todoItemJpaRepository;
  }

  @Override
  public int getMaxOrder(final long registeredBy) {
    return Optional.ofNullable(
        from(todoItem)
        .where(
            todoItem.isDeleted.isFalse(),
            todoItem.registeredBy.eq(registeredBy))
        .select(todoItem.numberOfOrder.max())
            .fetchOne()
    ).orElse(0);
  }

  @Override
  public TodoItem save(final TodoItem todoItem) {
    return todoItemJpaRepository.save(todoItem);
  }

  @Override
  public Page<TodoItem> search(final TodoItemSearchQuery query, final Pageable page) {
    final JPQLQuery<TodoItem> jpqlQuery = from(todoItem)
        .where(
            query.forRegisteredBy(todoItem.registeredBy::eq)
        );
    final List<TodoItem> results = getQuerydsl().applyPagination(page, jpqlQuery).fetch();
    return new PageImpl<>(results, page, jpqlQuery.fetchCount());
  }

  @Override
  public TodoItem findById(final Long seq) {
    return todoItemJpaRepository.findById(seq).orElseThrow(EntityNotFoundException::new);
  }
}
