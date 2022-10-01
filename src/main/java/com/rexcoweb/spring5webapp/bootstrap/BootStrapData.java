package com.rexcoweb.spring5webapp.bootstrap;

import com.rexcoweb.spring5webapp.domain.Author;
import com.rexcoweb.spring5webapp.domain.Book;
import com.rexcoweb.spring5webapp.domain.Publisher;
import com.rexcoweb.spring5webapp.repository.AuthorRepository;
import com.rexcoweb.spring5webapp.repository.BookRepository;
import com.rexcoweb.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher ben = new Publisher("22 ikosi lane", "Ketu", "Lagos", "12022");
        publisherRepository.save(ben);


        Author mark = new Author("Mark", "Behler");
        Book jdbc = new Book("JDBC", "24536");

        savePublisher(ben, mark, jdbc);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "84672683" );

        savePublisher(ben, rod, noEJB);


        System.out.println("Started in BootStrap mode");
        System.out.println("Number of Books in repository : "+ bookRepository.count());
        System.out.println("Number of Publisher in repository : "+ publisherRepository.count());
        System.out.println("Publishers book count -> " + (long) ben.getBooks().size());

    }

    private void savePublisher(Publisher ben, Author rod, Book noEJB) {
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(ben);
        ben.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(ben);
    }
}
