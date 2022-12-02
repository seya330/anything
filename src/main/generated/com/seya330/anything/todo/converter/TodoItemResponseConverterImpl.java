package com.seya330.anything.todo.converter;

import com.seya330.anything.todo.dto.TodoItemDto;
import com.seya330.anything.todo.payload.TodoItemResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-02T16:06:26+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_282 (AdoptOpenJDK)"
)
@Component
public class TodoItemResponseConverterImpl implements TodoItemResponseConverter {

    @Override
    public TodoItemResponse convert(TodoItemDto source) {
        if ( source == null ) {
            return null;
        }

        TodoItemResponse.TodoItemResponseBuilder todoItemResponse = TodoItemResponse.builder();

        return todoItemResponse.build();
    }

    @Override
    public List<TodoItemResponse> convert(List<TodoItemDto> source) {
        if ( source == null ) {
            return null;
        }

        List<TodoItemResponse> list = new ArrayList<TodoItemResponse>( source.size() );
        for ( TodoItemDto todoItemDto : source ) {
            list.add( convert( todoItemDto ) );
        }

        return list;
    }
}
