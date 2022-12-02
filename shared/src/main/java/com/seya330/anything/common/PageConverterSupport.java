package com.seya330.anything.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Objects;

public interface PageConverterSupport {
  default <T, R> Page<R> convert(Page<T> source, Converter<List<T>, List<R>> converter) {
    return new PageImpl<>(Objects.requireNonNull(converter.convert(source.getContent())), source.getPageable(), source.getTotalElements());
  }
}
