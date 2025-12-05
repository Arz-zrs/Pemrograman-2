package com.example.studentdata.repository;

import com.example.studentdata.model.StudentDTO;

import java.util.List;

public interface StudentRepository {
    List<StudentDTO> getAll();
    void save(StudentDTO studentDTO);
    void update(String oldId, String newId, String newName);
    boolean delete(String id);
    boolean exists(String id);
}