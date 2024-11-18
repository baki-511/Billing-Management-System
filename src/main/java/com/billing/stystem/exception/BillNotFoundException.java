package com.billing.stystem.exception;

public class BillNotFoundException extends RuntimeException{
    public BillNotFoundException(Long billId) {
        super("Bill NOT Found With ID : " + billId);
    }
}
