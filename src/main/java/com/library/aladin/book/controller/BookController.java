package com.library.aladin.book.controller;

import com.library.aladin.book.dto.request.BookCreateRequestDto;
import com.library.aladin.book.dto.response.BookCreateResponseDto;
import com.library.aladin.book.dto.response.BookResponseDto;
import com.library.aladin.book.service.BookService;
import com.library.aladin.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 도서 등록
    @PostMapping
    public ResponseEntity<ApiResponse<BookCreateResponseDto>> createBook(@RequestBody BookCreateRequestDto request) {
        BookCreateResponseDto response = bookService.createBook(request);
        return ResponseEntity.ok(ApiResponse.ok("도서가 등록되었습니다.", response));
    }

    // 도서 단건 조회
    @GetMapping("/{bookId}")
    public ResponseEntity<ApiResponse<BookResponseDto>> getBook(@PathVariable Long bookId) {
        BookResponseDto response = bookService.getBook(bookId);
        return ResponseEntity.ok(ApiResponse.ok("도서 조회 성공", response));
    }

}
