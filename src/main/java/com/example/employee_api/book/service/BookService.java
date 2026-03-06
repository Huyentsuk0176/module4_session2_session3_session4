package com.example.employee_api.book.service;

import com.example.employee_api.book.dto.BookRequest;
import com.example.employee_api.book.model.Book;
import java.util.Map;
import java.util.List;

public interface BookService {

    Book createBook(BookRequest request);

    List<Book> getAllBooks();

    Book getBookById(Long id);
    List<Book> searchByTitle(String keyword);

    List<Book> getBookHighPrice();

    List<Map<String, Object>> statisticsByAuthor();
}
