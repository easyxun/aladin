package com.library.aladin.book.dto.request;

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
}
