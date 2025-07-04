package com.library.aladin.book.service;

import com.library.aladin.book.domain.Book;
import com.library.aladin.book.dto.request.BookCreateRequestDto;
import com.library.aladin.book.dto.request.BookUpdateRequestDto;
import com.library.aladin.book.dto.response.BookCreateResponseDto;
import com.library.aladin.book.dto.response.BookResponseDto;
import com.library.aladin.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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

    /**
     * 도서 전체 조회 (is_deleted = false)
     */
    public List<BookResponseDto> getAllBook() {
        List<Book> books = bookMapper.findAllBooks();
        return books.stream()
                .map(BookResponseDto::fromEntity)
                .toList();
    }

    /**
     * 도서 수정
     */
    public BookResponseDto updateBook(BookUpdateRequestDto request) {
        Book book = bookMapper.findById(request.getBookId());
        if (book == null) {
            throw new IllegalArgumentException("없음");
        }

        book.updateBook(
                StringUtils.hasText(request.getBookTitle()) ? request.getBookTitle() : book.getBookTitle(),
                StringUtils.hasText(request.getBookAuthor()) ? request.getBookAuthor() : book.getBookAuthor(),
                StringUtils.hasText(request.getBookPublisher()) ? request.getBookPublisher() : book.getBookPublisher(),
                StringUtils.hasText(request.getBookDesc()) ? request.getBookDesc() : book.getBookDesc(),
                request.getBookPrice() != null ? request.getBookPrice() : book.getBookPrice(),
                StringUtils.hasText(request.getBookThumbnail()) ? request.getBookThumbnail() : book.getBookThumbnail(),
                request.getCategoryId() != null ? request.getCategoryId() : book.getCategoryId()
        );

        bookMapper.updateBook(book);

        return BookResponseDto.fromEntity(book);
    }

    /**
     * 도서 삭제
     * @param bookId 삭제할 도서의 ID
     */
    public BookResponseDto deleteBook(Long bookId) {
        Book book = bookMapper.findById(bookId);
        if (book == null) {
            throw new IllegalArgumentException("없음");
        }
        book.deleteBook();
        bookMapper.deleteBook(book);

        return BookResponseDto.fromEntity(book);
    }

    /**
     * 도서 검색
     * @param keyword 키워드
     * @param categoryId 카테고리 ID
     * @param tagId 태그 ID
     */
    public List<BookResponseDto> searchBooks(String keyword, Long categoryId, Long tagId) {
        List<Book> books = bookMapper.searchBooks(keyword, categoryId, tagId);
        if (books.isEmpty()) {
            throw new IllegalArgumentException("없음");
        }
        return books.stream()
                .map(BookResponseDto::fromEntity)
                .toList();
    }

}
