package org.example.libraryverse.services;

import org.example.libraryverse.models.Author;
import org.example.libraryverse.models.Publisher;
import org.example.libraryverse.repositories.AuthorRepository;
import org.example.libraryverse.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisher(Long id){
        Publisher publisher= publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("Author with given ID Not Found"));
        return publisher;
    }

    public void addPublisher(Publisher b){
        publisherRepository.save(b);
    }


    public void updatePublisher(Publisher b){
        publisherRepository.save(b);
    }

    public void removePublisher(Long id){
        Publisher a =publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("Author Not Found with given ID"));
        publisherRepository.deleteById(a.getId());
    }




}


