package com.desafio.techmanage.exceptions.business;

public class DataAlreadyRegisteredException extends RuntimeException {

    public DataAlreadyRegisteredException(String field, String data) {
        super(field + " " + data + " já está registrado!");
    }
}
