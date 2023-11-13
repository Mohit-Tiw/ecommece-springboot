package com.mohit.ecommercedemo.service;

import com.mohit.ecommercedemo.dto.CategoryDto;
import com.mohit.ecommercedemo.entity.Category;
import com.mohit.ecommercedemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        System.out.println(category);
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        }
        throw new RuntimeException("Category not found for id: " + id);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long id, Category category){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category categoryFromDB = optionalCategory.get();
            categoryFromDB.setName(category.getName());
            categoryFromDB.setDescription(category.getDescription());
            return categoryRepository.save(categoryFromDB);
        }
        throw new RuntimeException("Category not found for id: " + id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
