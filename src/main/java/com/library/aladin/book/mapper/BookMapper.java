package com.library.aladin.book.mapper;

import com.library.aladin.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    // 도서 등록
    void createBook(Book book);

    // 도서 아이디로 도서 반환
    Book findById(Long bookId);
}
