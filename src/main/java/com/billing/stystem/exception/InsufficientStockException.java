package com.billing.stystem.exception;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(Integer productId) {
        super("Insufficient stock for product: " + productId);
    }
}
