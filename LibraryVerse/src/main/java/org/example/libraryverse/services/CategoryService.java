package org.example.libraryverse.services;

import org.example.libraryverse.models.Category;
import org.example.libraryverse.models.Publisher;
import org.example.libraryverse.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public Category findCategory(Long id){
        Category category= categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category with given ID Not Found"));
        return category;
    }

    public void addCategory(Category b){
        categoryRepository.save(b);
    }


    public void updateCategory(Category b){
        categoryRepository.save(b);
    }

    public void removeCategory(Long id){
        Category a =categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Not Found with given ID"));
        categoryRepository.deleteById(a.getId());
    }




}
