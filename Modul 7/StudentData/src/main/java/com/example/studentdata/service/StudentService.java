package com.example.studentdata.service;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.MemoryStudentRepository;
import com.example.studentdata.repository.StudentRepository;
import com.example.studentdata.validation.StudentValidator;

import java.util.List;

public class StudentService {
    private final MemoryStudentRepository repository;
    private final StudentValidator validator = new StudentValidator();

    public StudentService(StudentRepository repository) {
        this.repository = (MemoryStudentRepository) repository;
    }

    public List<Student> getAll() {
        return repository.getAll();
    }

    public boolean addStudent(String id, String name) {
        if (validator.isValidInput(id, name)) return false;
        return repository.add(new Student(id, name));
    }

    public boolean updateStudent(String oldId, String newId, String name) {
        if (validator.isValidInput(newId, name)) return false;

        boolean duplicateId =
                repository.getAll().stream()
                        .anyMatch(s -> s.getId().equals(newId) && !s.getId().equals(oldId));

        if (duplicateId) return false;

        return repository.update(oldId, new Student(newId, name));
    }

    public boolean deleteStudent(String id) {
        return repository.delete(id);
    }}
