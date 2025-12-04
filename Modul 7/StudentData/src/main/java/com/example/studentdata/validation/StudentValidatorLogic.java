package com.example.studentdata.validation;

public class StudentValidatorLogic implements StudentValidator {
    public String validate(String id, String name) {
        if (id == null || id.isBlank())
            return "NIM tidak boleh kosong!";
        if (name == null || name.isBlank())
            return "Nama tidak boleh kosong!";
        return null;
    }
}
