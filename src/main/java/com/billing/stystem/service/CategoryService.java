package com.billing.stystem.service;

import com.billing.stystem.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(Category category);
    
    public List<Category> getAllCategories();
    
    public Category getCategoryById(Integer categoryId);
    
    public String deleteCategoryById(Integer categoryId);
    
    public Category updateCategory(Category category);
}
