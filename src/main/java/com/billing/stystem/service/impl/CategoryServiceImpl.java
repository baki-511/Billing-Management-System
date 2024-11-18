package com.billing.stystem.service.impl;

import com.billing.stystem.entity.Category;
import com.billing.stystem.exception.CategoryNotFoundException;
import com.billing.stystem.repository.CategoryRepository;
import com.billing.stystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));
    }
    
    @Override
    public String deleteCategoryById(Integer categoryId) {
        Category categoryById = getCategoryById(categoryId);
        categoryRepository.delete(categoryById);
        return "Category Deleted Successfully!";
    }
    
    @Override
    public Category updateCategory(Category category) {
        getCategoryById(category.getCategoryId());
        return categoryRepository.save(category);
    }
}
