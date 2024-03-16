package org.example.libraryverse.repositories;

import org.example.libraryverse.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
