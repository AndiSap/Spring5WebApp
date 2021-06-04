package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // initialize data here
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "123456");

        Publisher pub = new Publisher();
        pub.setName("SFG Publishing");
        pub.setCity("St Petersburg");
        publisherRepository.save(pub);

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(pub);
        pub.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(pub);


        Author rod = new Author("Rod", "Johnson");
        Book bookRod = new Book("J2EE Development without EJB", "23523456457");

        rod.getBooks().add(bookRod);
        bookRod.getAuthors().add(rod);
        bookRod.setPublisher(pub);
        pub.getBooks().add(bookRod);

        authorRepository.save(rod);
        bookRepository.save(bookRod);
        publisherRepository.save(pub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of books of publisher: " + pub.getBooks().size());
    }
}
