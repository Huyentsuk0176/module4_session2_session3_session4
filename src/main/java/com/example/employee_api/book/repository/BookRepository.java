package com.example.employee_api.book.repository;

import com.example.employee_api.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 1. Query Method
    List<Book> findByTitleContaining(String keyword);

    // 2. JPQL
    @Query("SELECT b FROM Book b WHERE b.price > (SELECT AVG(b2.price) FROM Book b2)")
    List<Book> getBookHighPrice();

    // 3. Native SQL
    @Query(value = """
            SELECT a.id, a.name, COUNT(b.id)
            FROM author a
            LEFT JOIN book b ON a.id = b.author_id
            GROUP BY a.id, a.name
            """, nativeQuery = true)
    List<Object[]> statisticsByAuthor();
}