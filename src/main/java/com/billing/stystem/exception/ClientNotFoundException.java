package com.billing.stystem.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Integer clientId) {
        super("Client NOT Found With ID : " + clientId);
    }
}
