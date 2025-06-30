package com.library.aladin.book.dto.request;

import com.library.aladin.book.domain.Book;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class BookCreateRequestDto {
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookDesc;
    private BigDecimal bookPrice;
    private String bookThumbnail;
    private Long categoryId;

    public Book toEntity() {
        return Book.builder()
                .bookTitle(this.bookTitle)
                .bookAuthor(this.bookAuthor)
                .bookPublisher(this.bookPublisher)
                .bookDesc(this.bookDesc)
                .bookPrice(this.bookPrice)
                .bookThumbnail(this.bookThumbnail)
                .categoryId(this.categoryId)
                .build();
    }

}
