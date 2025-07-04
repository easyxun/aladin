package com.library.aladin.book.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
public class Book {

    @Setter
    private Long bookId;

    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookDesc;
    private BigDecimal bookPrice;
    private String bookThumbnail;
    private Long categoryId;
    private boolean isDeleted;

    public void updateBook(String bookTitle, String bookAuthor, String bookPublisher,
                           String bookDesc, BigDecimal bookPrice, String bookThumbnail,
                           Long categoryId) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookDesc = bookDesc;
        this.bookPrice = bookPrice;
        this.bookThumbnail = bookThumbnail;
        this.categoryId = categoryId;
    }

    public void deleteBook() {
        this.isDeleted = true;
    }
}
