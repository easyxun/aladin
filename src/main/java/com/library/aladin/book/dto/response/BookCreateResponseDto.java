package com.library.aladin.book.dto.response;

import com.library.aladin.book.domain.Book;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class BookCreateResponseDto {
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookDesc;
    private BigDecimal bookPrice;
    private String bookThumbnail;
    private Long categoryId;

    public static BookCreateResponseDto fromEntity(Book book) {
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
