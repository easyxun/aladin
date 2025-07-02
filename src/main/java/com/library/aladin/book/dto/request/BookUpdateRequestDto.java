package com.library.aladin.book.dto.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BookUpdateRequestDto {
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookDesc;
    private BigDecimal bookPrice;
    private String bookThumbnail;
    private Long categoryId;
}