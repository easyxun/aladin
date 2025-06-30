package com.library.aladin.book.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Book {
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookDesc;
    private BigDecimal bookPrice;
    private String bookThumbnail;
    private Long categoryId;
}
