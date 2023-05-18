package ru.clevertec.clevertec_final.security.exceptions;

public class MyRoleNotFoundException extends RuntimeException {
    public MyRoleNotFoundException(String message) {
        super(message);
    }
}