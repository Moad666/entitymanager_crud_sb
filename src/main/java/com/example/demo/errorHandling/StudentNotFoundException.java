package com.example.demo.errorHandling;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException(String message) {
		super(message);
	}

}
