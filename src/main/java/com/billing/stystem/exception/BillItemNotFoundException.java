package com.billing.stystem.exception;

public class BillItemNotFoundException extends RuntimeException{
    public BillItemNotFoundException(Long billItemId) {
        super("Bill Item NOT Found With ID : " + billItemId);
    }
}
