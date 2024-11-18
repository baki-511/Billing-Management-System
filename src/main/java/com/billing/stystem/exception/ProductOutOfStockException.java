package com.billing.stystem.exception;

public class ProductOutOfStockException extends RuntimeException{
    public ProductOutOfStockException() {
        super("Products Are OUT Of Stock!");
    }
}
