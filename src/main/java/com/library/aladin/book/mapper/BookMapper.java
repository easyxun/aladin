package com.library.aladin.book.mapper;

import com.library.aladin.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    // 도서 등록
    void createBook(Book book);

    // 도서 아이디로 도서 반환
    Book findById(Long bookId);

    // 도서 전체 반환 (is_deleted = false)
    List<Book> findAllBooks();

    // 도서 수정
    void updateBook(Book book);

    // 도서 삭제
    void deleteBook(Book book);

    // 도서 검색
    List<Book> searchBooks(String keyword, Long categoryId, Long tagId);
}
