package com.example.employee_api.book.service;

import com.example.employee_api.author.model.Author;
import com.example.employee_api.author.repository.AuthorRepository;
import com.example.employee_api.book.dto.BookRequest;
import com.example.employee_api.book.model.Book;
import com.example.employee_api.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book createBook(BookRequest request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Tac gia khong ton tai"));

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPrice(request.getPrice());
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> searchByTitle(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    @Override
    public List<Book> getBookHighPrice() {
        return bookRepository.getBookHighPrice();
    }

    @Override
    public List<Map<String, Object>> statisticsByAuthor() {
        List<Object[]> rows = bookRepository.statisticsByAuthor();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : rows) {
            Map<String, Object> item = new HashMap<>();
            item.put("authorId", row[0]);
            item.put("authorName", row[1]);
            item.put("totalBooks", row[2]);
            result.add(item);
        }

        return result;
    }
}