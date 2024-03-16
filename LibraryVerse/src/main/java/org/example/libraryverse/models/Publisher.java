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
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "Publisher name", length = 200, nullable = false)
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
    //here publishers is the name of Hashset of Publisher class which mapped
    private Set<Book> books = new HashSet<>();


}
