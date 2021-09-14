package com.fifthhomework.fifthhomework.exception;

public class InstructorIsAlreadyExistException extends RuntimeException {
    public InstructorIsAlreadyExistException() {
        super("Instructor daha önce oluştu.");
    }
}
