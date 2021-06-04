package com.example.spring5webapp.repositories;

import com.example.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * This will be implemented by String during runtime
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
