package com.cloup.api.mapper;

import com.cloup.data.entities.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface BookMapper {

    com.cloup.api.v1.resources.Book map(Book book);

    List<com.cloup.api.v1.resources.Book> map(Iterable<Book> books);

    Book mapToEntity(com.cloup.api.v1.resources.Book book);
}
