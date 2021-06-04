package com.example.spring5webapp.repositories;

import com.example.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * This will be implemented by String during runtime
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

