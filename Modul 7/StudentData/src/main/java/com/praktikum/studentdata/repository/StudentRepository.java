package com.praktikum.studentdata.repository;

import com.praktikum.studentdata.model.StudentDTO;

import java.util.List;

public interface StudentRepository {
    List<StudentDTO> getAll();
    void add(StudentDTO studentDTO);
    void update(String oldId, String newId, String newName);
    boolean delete(String id);
    boolean exists(String id);
}