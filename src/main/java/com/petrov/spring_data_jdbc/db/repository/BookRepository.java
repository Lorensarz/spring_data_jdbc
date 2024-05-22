package com.petrov.spring_data_jdbc.db.repository;

import com.petrov.spring_data_jdbc.db.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
