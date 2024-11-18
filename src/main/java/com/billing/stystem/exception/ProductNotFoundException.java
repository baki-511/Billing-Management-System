package com.billing.stystem.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer prodId) {
        super("Product NOT Found With ID " + prodId);
    }
}
