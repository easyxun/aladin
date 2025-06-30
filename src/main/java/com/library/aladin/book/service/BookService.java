package com.library.aladin.book.service;

import com.library.aladin.book.domain.Book;
import com.library.aladin.book.dto.request.BookCreateRequestDto;
import com.library.aladin.book.dto.response.BookCreateResponseDto;
import com.library.aladin.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    /**
     * 도서 등록
     *
     * @param request 등록할 도서 정보
     *                {
     *                "bookTitle": "자바의 정석",
     *                "bookAuthor": "남궁성",
     *                "bookPublisher": "도우출판",
     *                "bookDesc": "자바 입문서",
     *                "bookPrice": 32000.00,
     *                "bookThumbnail": "https://",
     *                "categoryId": 1
     *                }
     */
    public BookCreateResponseDto createBook(BookCreateRequestDto request) {
        // 1. DB에 저장 할 Book 객체 생성 (builder 사용)
        Book book = Book.builder()
                .bookTitle(request.getBookTitle())
                .bookAuthor(request.getBookAuthor())
                .bookPublisher(request.getBookPublisher())
                .bookDesc(request.getBookDesc())
                .bookPrice(request.getBookPrice())
                .bookThumbnail(request.getBookThumbnail())
                .categoryId(request.getCategoryId())
                .build();

        // 2. DB에 저장 (insert + bookId 자동 생성됨 - setter 사용)
        bookMapper.createBook(book);

        // 3. 응답 객체 생성
        return BookCreateResponseDto.builder()
                .bookId(book.getBookId())
                .bookTitle(book.getBookTitle())
                .bookAuthor(book.getBookAuthor())
                .bookPublisher(book.getBookPublisher())
                .bookDesc(book.getBookDesc())
                .bookPrice(book.getBookPrice())
                .bookThumbnail(book.getBookThumbnail())
                .categoryId(book.getCategoryId())
                .build();
    }
}
