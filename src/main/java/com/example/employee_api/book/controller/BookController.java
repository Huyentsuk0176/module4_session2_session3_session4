package com.example.employee_api.book.controller;

import com.example.employee_api.book.dto.BookRequest;
import com.example.employee_api.book.model.Book;
import com.example.employee_api.book.service.BookService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE BOOK
    @PostMapping
    public Book createBook(@RequestBody BookRequest request) {
        return bookService.createBook(request);
    }

    // GET ALL BOOKS
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET BOOK BY ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // SEARCH BOOK BY TITLE
    @GetMapping("/searchByTitle")
    public List<Book> searchByTitle(@RequestParam String keyword) {
        return bookService.searchByTitle(keyword);
    }

    // BOOK PRICE HIGHER THAN AVERAGE
    @GetMapping("/getBookHightPrice")
    public List<Book> getBookHighPrice() {
        return bookService.getBookHighPrice();
    }

    // STATISTICS BOOK BY AUTHOR
    @GetMapping("/statisticsByAuthor")
    public List<Map<String, Object>> statisticsByAuthor() {
        return bookService.statisticsByAuthor();
    }
}