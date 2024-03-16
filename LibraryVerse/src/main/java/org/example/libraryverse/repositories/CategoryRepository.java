package org.example.libraryverse.repositories;

import org.example.libraryverse.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
