package com.example.spring5webapp.repositories;

import com.example.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * This will be implemented by String during runtime
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
