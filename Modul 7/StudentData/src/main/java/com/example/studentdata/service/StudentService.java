package com.example.studentdata.service;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.StudentRepository;
import com.example.studentdata.validation.StudentValidator;

import java.util.List;

public class StudentService {

    private final StudentRepository repository;
    private final StudentValidator validator = new StudentValidator();

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() {
        return repository.getAll();
    }

    public boolean addStudent(String id, String name) {
        if (validator.hasInvalidInput(id, name)) return false;

        boolean duplicate = repository.getAll().stream()
                .anyMatch(s -> s.getId().equals(id));

        if (duplicate) return false;

        return repository.add(new Student(id, name));
    }

    public boolean updateStudent(String oldId, String newId, String name) {
        if (validator.hasInvalidInput(newId, name)) return false;

        boolean duplicate = repository.getAll().stream()
                .anyMatch(s -> s.getId().equals(newId) && !s.getId().equals(oldId));

        if (duplicate) return false;

        return repository.update(oldId, new Student(newId, name));
    }

    public boolean deleteStudent(String id) {
        return repository.delete(id);
    }
}
