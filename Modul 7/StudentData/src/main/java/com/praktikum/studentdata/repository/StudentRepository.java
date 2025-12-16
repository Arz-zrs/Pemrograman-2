package com.praktikum.studentdata.repository;

import com.praktikum.studentdata.model.StudentData;

import java.util.List;

public interface StudentRepository {
    List<StudentData> getAll();
    void add(StudentData studentData);
    void update(String oldId, String newId, String newName);
    boolean delete(String id);
    boolean exists(String id);
}