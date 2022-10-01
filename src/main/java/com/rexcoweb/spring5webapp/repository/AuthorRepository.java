package com.rexcoweb.spring5webapp.repository;

import com.rexcoweb.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
