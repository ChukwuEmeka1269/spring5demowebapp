package com.rexcoweb.spring5webapp.repository;

import com.rexcoweb.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
