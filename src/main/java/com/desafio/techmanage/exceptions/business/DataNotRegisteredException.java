package com.desafio.techmanage.exceptions.business;

public class DataNotRegisteredException extends RuntimeException {

    public DataNotRegisteredException() {
        super("Id não registrado!");
    }
}
