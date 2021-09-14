package com.fifthhomework.fifthhomework.exception;

public class StudentAgeNotValidException extends RuntimeException {

    public StudentAgeNotValidException() {
        super("Student yaş aralığı 18 - 40 olmalıdır.");
    }
}
