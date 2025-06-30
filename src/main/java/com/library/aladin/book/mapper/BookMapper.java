package com.library.aladin.book.mapper;

import com.library.aladin.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    // 도서 등록
    void createBook(Book book);
}
