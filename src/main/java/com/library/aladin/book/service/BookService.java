package com.library.aladin.book.service;

import com.library.aladin.book.domain.Book;
import com.library.aladin.book.dto.request.BookCreateRequestDto;
import com.library.aladin.book.dto.response.BookCreateResponseDto;
import com.library.aladin.book.dto.response.BookResponseDto;
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
        // 1. Book 생성
        Book book = request.toEntity();

        // 2. DB 저장
        bookMapper.createBook(book);

        // 3. 응답 생성
        return BookCreateResponseDto.fromEntity(book);
    }

    /**
     * 도서 단건 조회
     *
     * @param bookId 조회할 도서의 ID
     */
    public BookResponseDto getBook(Long bookId) {
        Book book = bookMapper.findById(bookId);
        if (book == null) {
            throw new IllegalArgumentException("없음");
        }
        return BookResponseDto.fromEntity(book);
    }

}
