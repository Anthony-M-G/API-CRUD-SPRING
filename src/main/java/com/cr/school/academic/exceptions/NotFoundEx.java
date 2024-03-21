package com.cr.school.academic.exceptions;

public class NotFoundEx extends Exception{

    public NotFoundEx() {
        super("Registro no encontrado");
    }

    public NotFoundEx(String message) {
        super(message);
    }

    public NotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }
}
