package com.example.ulbitvspring.exceptions;

public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
