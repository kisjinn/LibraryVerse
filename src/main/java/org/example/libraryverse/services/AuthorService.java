package org.example.libraryverse.services;

import org.example.libraryverse.models.Author;
import org.example.libraryverse.models.Book;
import org.example.libraryverse.repositories.AuthorRepository;
import org.example.libraryverse.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthor(Long id){
        Author author= authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author with given ID Not Found"));
        return author;
    }

    public void addAuthor(Author b){
        authorRepository.save(b);
    }


    public void updateAuthor(Author b){
        authorRepository.save(b);
    }

    public void removeAuthor(Long id){
        Author a = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author Not Found with given ID"));
        authorRepository.deleteById(a.getId());
    }




}

