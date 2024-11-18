package com.billing.stystem.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Integer categoryId) {
        super("Category NOT Found With ID : " + categoryId);
    }
}
