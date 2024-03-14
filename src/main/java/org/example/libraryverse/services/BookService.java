package org.example.libraryverse.services;

import org.example.libraryverse.models.Book;
import org.example.libraryverse.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBookk(){
         return bookRepository.findAll();
    }

    public Book findBook(Long id){
        Book book= bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found"));
        return book;
    }

    public void adddBook(Book b){
        bookRepository.save(b);
    }

    public void removeBook(Long id){
        Book book= bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found with given ID"));
        bookRepository.deleteById(book.getId());
    }








}
