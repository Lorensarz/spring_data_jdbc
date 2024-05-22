package com.petrov.spring_data_jdbc.service;

import com.petrov.spring_data_jdbc.db.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    public Iterable<Book> findAll() {
        String query = "SELECT * FROM books";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book findById(Long id) {
        String query = "SELECT * FROM books WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Book.class), id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Книга с id " + id + " не найдена!", 1);
        }
    }

    public void save(Book book) {
        String query = "INSERT INTO books (title, author, publication_year) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public void delete(Long id) {
        String query = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
