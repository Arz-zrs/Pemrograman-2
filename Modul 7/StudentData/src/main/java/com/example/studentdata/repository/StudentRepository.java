package com.example.studentdata.repository;

import com.example.studentdata.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    boolean add(Student student);
    boolean update(String oldId, Student newStudent);
    boolean delete(String id);
}