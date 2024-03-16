package org.example.libraryverse.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String isbn;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    public Book(String name, String isbn, String description) {
        this.name = name;
        this.isbn = isbn;
        this.description = description;
     }

    @ManyToMany(cascade = {CascadeType.ALL})
    //whatever changes will happen on book same will be reflected on authors related to book
    @JoinTable(name = "books_authors", joinColumns = {@JoinColumn(name="book_id")}
                                       ,inverseJoinColumns =  {@JoinColumn(name="author_id")})
    private Set<Author> authors= new HashSet<>();



    //relationship between book and category
    @ManyToMany(cascade = {CascadeType.ALL})
    //whatever changes will happen on book same will be reflected on authors related to book
    @JoinTable(name = "books_categoriess", joinColumns = {@JoinColumn(name="book_id")}
                                          ,inverseJoinColumns =  {@JoinColumn(name="category_id")})
    private Set<Category> categories = new HashSet<>();

    //relationship between book and publishers
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name= "books_publishers", joinColumns = {@JoinColumn(name= "book_id")},
                                         inverseJoinColumns = {@JoinColumn(name= "publisher_id")})
    private Set<Publisher> publishers= new HashSet<>();


    //as relation between book and publisher is bidirectional
          // so when removing a book then same book should be removed from books set as well as from publishers set
          // so when adding a book then same book should be added from books set as well as from publishers set
    public void deletePublisher(Publisher publisher){
        this.publishers.remove(publisher);
        publisher.getBooks().remove(this);
    }

    public void adPublisher(Publisher publisher){
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }



    public void deleteAuthor(Author author){
        this.authors.remove(author);
        author.getBooks().remove(this);
    }

    public void adAuthor(Author author){
        this.authors.add(author); // Adds the author to the set of authors associated with this book
        //Lombok has automatically generated the getBooks() for set of books
        author.getBooks().add(this);// Adds this book to the set of books associated with the author
                                    //This adds the current Book instance (this) to the set of books associated with the author.
    }



    public void deleteCategory(Category category){
        this.categories.remove(category);
        category.getBooks().remove(this);
    }
    public void adCategory(Category category){
        this.categories.add(category);
        category.getBooks().add(this);
    }

}
