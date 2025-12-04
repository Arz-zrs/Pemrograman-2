package com.example.studentdata.repository;

import com.example.studentdata.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    void save(Student student);
    void update(String oldId, String newId, String newName);
    boolean delete(String id);
    boolean exists(String id);
}