package org.example.libraryverse;

import org.example.libraryverse.models.Author;
import org.example.libraryverse.models.Book;
import org.example.libraryverse.models.Category;
import org.example.libraryverse.models.Publisher;
import org.example.libraryverse.services.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class LibraryVerseApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryVerseApplication.class, args);
    }
    //this method will exexute when we launch application for the first time
    @Bean
    public CommandLineRunner initialCreate(BookService bookService){
        //adding dummy data
        return (args)->{
            Book book1 = new Book("XYZ", "Book name ", "My book");
            Author author1 = new Author("Sakshi Jinnewar", "Test description");
            Category category1 = new Category("Business books");
            Publisher publisher1 = new Publisher("First Publisher");
            book1.adAuthor(author1);
            book1.adCategory(category1);
            book1.adPublisher(publisher1);
            bookService.adddBook(book1);

            Book book2 = new Book("ABC1", "Book name 1", "My first book");
            Author author2 = new Author("Snehal Jinnewar", "Test description one");
            Category category2 = new Category("Science books");
            Publisher publisher2 = new Publisher("Second Publisher");
            book2.adAuthor(author2);
            book2.adCategory(category2);
            book2.adPublisher(publisher2);
            bookService.adddBook(book2);

            Book book3 = new Book("ABC21", "Book name 2", "My second book");
            Author author3 = new Author("Anoo K", "Test description two");
            Category category3 = new Category("Fiction books");
            Publisher publisher3 = new Publisher("Third Publisher");
            book3.adAuthor(author3);
            book3.adCategory(category3);
            book3.adPublisher(publisher3);
            bookService.adddBook(book3);
        };


    }
}
