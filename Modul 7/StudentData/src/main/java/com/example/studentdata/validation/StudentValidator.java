package com.example.studentdata.validation;

public class StudentValidator {
    public boolean isValidId(String id) {
        return id != null && !id.isBlank();
    }

    public boolean isValidName(String name) {
        return name != null && !name.isBlank();
    }

    public boolean isValidInput(String id, String name) {
        return !isValidId(id) || !isValidName(name);
    }
}
